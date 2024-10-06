package com.payroll.payroll_service.domain;

import java.time.LocalDate;

public class EmployeeRecordDTO {
	private String empId;
	private String firstName;
	private String lastName;
	private String designation;
	private String eventType;
	private LocalDate startDate;
	private LocalDate eventDate;
	private String comments;
	private String salary;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeRecordDTO [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", eventType=" + eventType + ", startDate=" + startDate
				+ ", eventDate=" + eventDate + ", comments=" + comments + ", salary=" + salary + "]";
	}

}
