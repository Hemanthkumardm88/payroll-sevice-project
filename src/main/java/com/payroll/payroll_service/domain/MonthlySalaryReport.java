package com.payroll.payroll_service.domain;

public class MonthlySalaryReport {
	private String EventDate;
	private Double TotalSalary;
	private int TotalEmployees;
	public String getEventDate() {
		return EventDate;
	}
	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}
	public Double getTotalSalary() {
		return TotalSalary;
	}
	public void setTotalSalary(Double totalSalary) {
		TotalSalary = totalSalary;
	}
	public int getTotalEmployees() {
		return TotalEmployees;
	}
	public void setTotalEmployees(int totalEmployees) {
		TotalEmployees = totalEmployees;
	}
	@Override
	public String toString() {
		return "MonthlySalaryReport [EventDate=" + EventDate + ", TotalSalary=" + TotalSalary + ", TotalEmployees="
				+ TotalEmployees + "]";
	}

	
}
