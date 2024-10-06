package com.payroll.payroll_service.dao;

import java.util.List;

import com.payroll.payroll_service.domain.EmployeeFinancialReport;
import com.payroll.payroll_service.domain.MonthlyAmountReleased;
import com.payroll.payroll_service.domain.MonthlyEmployeeData;
import com.payroll.payroll_service.domain.MonthlySalaryReport;
import com.payroll.payroll_service.domain.YearlyFinancialReport;

public interface EmployeeDao {

	List<MonthlyEmployeeData> findEmployeesByEvent(String string);

	List<MonthlySalaryReport> getMonthlySalaryReport();

	List<EmployeeFinancialReport> getEmployeeFinancialReport();

	List<MonthlyAmountReleased> getMonthlyAmountReleased();

	List<YearlyFinancialReport> getYearlyFinancialReport();

}
