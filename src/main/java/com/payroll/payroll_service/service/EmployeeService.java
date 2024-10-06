package com.payroll.payroll_service.service;

import java.util.List;

import com.payroll.payroll_service.domain.EmployeeFinancialReport;
import com.payroll.payroll_service.domain.MonthlyAmountReleased;
import com.payroll.payroll_service.domain.MonthlyEmployeeData;
import com.payroll.payroll_service.domain.MonthlySalaryReport;
import com.payroll.payroll_service.domain.YearlyFinancialReport;
import com.payroll.payroll_service.entity.Employee;

public interface EmployeeService {

	List<Employee> getTotalEmployees();

	List<MonthlyEmployeeData> getEmployeesJoinedMonthWise();

	List<MonthlyEmployeeData> getEmployeesExitedMonthWise();

	List<MonthlySalaryReport> getMonthlySalaryReport();

	List<EmployeeFinancialReport> getEmployeeFinancialReport();

	List<MonthlyAmountReleased> getMonthlyAmountReleased();

	List<YearlyFinancialReport> getYearlyFinancialReport();

}
