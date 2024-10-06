package com.payroll.payroll_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payroll.payroll_service.domain.EmployeeFinancialReport;
import com.payroll.payroll_service.domain.MonthlyAmountReleased;
import com.payroll.payroll_service.domain.MonthlyEmployeeData;
import com.payroll.payroll_service.domain.MonthlySalaryReport;
import com.payroll.payroll_service.domain.YearlyFinancialReport;
import com.payroll.payroll_service.entity.Employee;
import com.payroll.payroll_service.service.EmployeeFileService;
import com.payroll.payroll_service.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private EmployeeFileService employeeFileService;
    
    @PostMapping("/upload")
    public String uploadEmployeeFile(@RequestParam("file") MultipartFile file) {
        try {
            employeeFileService.processEmployeeFile(file);
            return "Employee file processed successfully.";
        } catch (Exception e) {
            return "Error processing file: " + e.getMessage();
        }
    }

    @GetMapping("/total-employees")
    public ResponseEntity<List<Employee>> getTotalEmployees() {
        List<Employee> totalEmployees = employeeService.getTotalEmployees();
        return ResponseEntity.ok(totalEmployees);
    }

    @GetMapping("/employees-joined-month-wise")
    public ResponseEntity<List<MonthlyEmployeeData>> getEmployeesJoinedMonthWise() {
        List<MonthlyEmployeeData> result = employeeService.getEmployeesJoinedMonthWise();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees-exited-month-wise")
    public ResponseEntity<List<MonthlyEmployeeData>> getEmployeesExitedMonthWise() {
        List<MonthlyEmployeeData> result = employeeService.getEmployeesExitedMonthWise();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/monthly-salary-report")
    public ResponseEntity<List<MonthlySalaryReport>> getMonthlySalaryReport() {
        List<MonthlySalaryReport> result = employeeService.getMonthlySalaryReport();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employee-financial-report")
    public ResponseEntity<List<EmployeeFinancialReport>> getEmployeeFinancialReport() {
        List<EmployeeFinancialReport> result = employeeService.getEmployeeFinancialReport();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/monthly-amount-released")
    public ResponseEntity<List<MonthlyAmountReleased>> getMonthlyAmountReleased() {
        List<MonthlyAmountReleased> result = employeeService.getMonthlyAmountReleased();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/yearly-financial-report")
    public ResponseEntity<List<YearlyFinancialReport>> getYearlyFinancialReport() {
        List<YearlyFinancialReport> result = employeeService.getYearlyFinancialReport();
        return ResponseEntity.ok(result);
    }
}
