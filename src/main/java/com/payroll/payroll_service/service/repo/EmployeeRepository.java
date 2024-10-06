package com.payroll.payroll_service.service.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.payroll.payroll_service.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.eventType = 'join' AND e.eventDate BETWEEN :start AND :end")
	List<Employee> findEmployeesJoinedInMonth(LocalDate start, LocalDate end);

	@Query("SELECT e FROM Employee e WHERE e.eventType = 'exit' AND e.eventDate BETWEEN :start AND :end")
	List<Employee> findEmployeesExitedInMonth(LocalDate start, LocalDate end);

	@Query("SELECT SUM(e.salary), COUNT(e) FROM Employee e WHERE e.eventType = 'salary' AND e.eventDate BETWEEN :start AND :end")
	List<Object[]> findMonthlySalaryReport(LocalDate start, LocalDate end);

	@Query("SELECT e FROM Employee e WHERE e.id = :empId")
	List<Employee> findEmployeeFinancialReport(Long empId);

	@Query("SELECT SUM(e.salary + e.bonus + e.reimbursement), COUNT(e) FROM Employee e WHERE e.eventDate BETWEEN :start AND :end")
	List<Object[]> findMonthlyTotalReleased(LocalDate start, LocalDate end);
}