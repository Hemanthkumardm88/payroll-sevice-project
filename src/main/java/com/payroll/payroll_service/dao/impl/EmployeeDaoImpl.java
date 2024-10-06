package com.payroll.payroll_service.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.payroll.payroll_service.dao.EmployeeDao;
import com.payroll.payroll_service.domain.EmployeeFinancialReport;
import com.payroll.payroll_service.domain.MonthlyAmountReleased;
import com.payroll.payroll_service.domain.MonthlyEmployeeData;
import com.payroll.payroll_service.domain.MonthlySalaryReport;
import com.payroll.payroll_service.domain.YearlyFinancialReport;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<MonthlyEmployeeData> findEmployeesByEvent(String eventType) {
		String sql = "SELECT EmpID, EmpFName, EmpLName, Designation, EventDate FROM EmployeeEvents WHERE Event = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MonthlyEmployeeData>(MonthlyEmployeeData.class), eventType);
	}

	public List<MonthlySalaryReport> getMonthlySalaryReport() {
		String sql = "SELECT EventDate, SUM(Value) AS TotalSalary, COUNT(DISTINCT EmpID) AS TotalEmployees FROM EmployeeEvents WHERE Event = 'SALARY' GROUP BY EventDate";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MonthlySalaryReport>(MonthlySalaryReport.class));
	}

	public List<EmployeeFinancialReport> getEmployeeFinancialReport() {
		String sql = "SELECT EmpID, EmpFName, EmpLName, SUM(Value) AS TotalPaid FROM EmployeeEvents WHERE Event IN ('SALARY', 'BONUS', 'REIMBURSEMENT') GROUP BY EmpID";
		return jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<EmployeeFinancialReport>(EmployeeFinancialReport.class));
	}

	public List<MonthlyAmountReleased> getMonthlyAmountReleased() {
		String sql = "SELECT EventDate, SUM(Value) AS TotalAmount, COUNT(DISTINCT EmpID) AS TotalEmployees FROM EmployeeEvents WHERE Event IN ('SALARY', 'BONUS', 'REIMBURSEMENT') GROUP BY EventDate";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MonthlyAmountReleased>(MonthlyAmountReleased.class));
	}

	public List<YearlyFinancialReport> getYearlyFinancialReport() {
		String sql = "SELECT Event, EmpID, EventDate, Value FROM EmployeeEvents WHERE YEAR(EventDate) = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<YearlyFinancialReport>(YearlyFinancialReport.class));
	}

}
