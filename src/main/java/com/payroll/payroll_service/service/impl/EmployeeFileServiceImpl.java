package com.payroll.payroll_service.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.payroll.payroll_service.domain.EmployeeRecordDTO;
import com.payroll.payroll_service.entity.Employee;
import com.payroll.payroll_service.service.EmployeeFileService;
import com.payroll.payroll_service.service.repo.EmployeeRepository;

public class EmployeeFileServiceImpl implements EmployeeFileService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

	public void processEmployeeFile(MultipartFile file) throws IOException {
		List<Employee> employees = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

			String line;
			while ((line = br.readLine()) != null) {
				// Process each line and create EmployeeRecordDTO
				EmployeeRecordDTO dto = mapLineToEmployeeDTO(line);

				// Convert DTO to Employee entity
				Employee employee = mapDTOToEmployeeEntity(dto);

				// Add to the list
				employees.add(employee);
			}
		}

		// Save all the employees to the database
		employeeRepository.saveAll(employees);
	}

	private EmployeeRecordDTO mapLineToEmployeeDTO(String line) {
		String[] fields = line.split(", ");

		EmployeeRecordDTO dto = new EmployeeRecordDTO();
		dto.setEmpId(fields[1]);
		dto.setFirstName(fields[2]);
		dto.setLastName(fields[3]);

		// EventType ONBOARD or SALARY
		dto.setEventType(fields[5]);

		// Parse event-specific fields
		if (fields[5].equalsIgnoreCase("ONBOARD")) {
			dto.setDesignation(fields[4]);
			dto.setStartDate(LocalDate.parse(fields[6], dateFormatter));
		} else if (fields[5].equalsIgnoreCase("SALARY")) {
			dto.setSalary(fields[3]);
		}

		dto.setEventDate(LocalDate.parse(fields[fields.length - 2], dateFormatter));
		dto.setComments(fields[fields.length - 1]);

		return dto;
	}

	private Employee mapDTOToEmployeeEntity(EmployeeRecordDTO dto) {
		Employee employee = new Employee();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEventType(dto.getEventType());
		employee.setEventDate(dto.getEventDate());

		if (dto.getEventType().equalsIgnoreCase("ONBOARD")) {
			employee.setDesignation(dto.getDesignation());
		} else if (dto.getEventType().equalsIgnoreCase("SALARY")) {
			employee.setSalary(new BigDecimal(dto.getSalary()));
		}

		return employee;
	}

}
