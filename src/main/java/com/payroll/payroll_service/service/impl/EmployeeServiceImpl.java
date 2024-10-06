package com.payroll.payroll_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.payroll.payroll_service.dao.EmployeeDao;
import com.payroll.payroll_service.domain.EmployeeFinancialReport;
import com.payroll.payroll_service.domain.MonthlyAmountReleased;
import com.payroll.payroll_service.domain.MonthlyEmployeeData;
import com.payroll.payroll_service.domain.MonthlySalaryReport;
import com.payroll.payroll_service.domain.YearlyFinancialReport;
import com.payroll.payroll_service.entity.Employee;
import com.payroll.payroll_service.service.EmployeeService;
import com.payroll.payroll_service.service.repo.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeDao dao;

	@Override
	public List<Employee> getTotalEmployees() {

		return employeeRepository.findAll();
	}

	public List<MonthlyEmployeeData> getEmployeesJoinedMonthWise() {
		return dao.findEmployeesByEvent("ONBOARD");
	}

	public List<MonthlyEmployeeData> getEmployeesExitedMonthWise() {
		return dao.findEmployeesByEvent("EXIT");
	}

	public List<MonthlySalaryReport> getMonthlySalaryReport() {
		return dao.getMonthlySalaryReport();
	}

	public List<EmployeeFinancialReport> getEmployeeFinancialReport() {
		return dao.getEmployeeFinancialReport();
	}

	public List<MonthlyAmountReleased> getMonthlyAmountReleased() {
		return dao.getMonthlyAmountReleased();
	}

	public List<YearlyFinancialReport> getYearlyFinancialReport() {
		return dao.getYearlyFinancialReport();
	}
}
