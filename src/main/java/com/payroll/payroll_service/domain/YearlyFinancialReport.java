package com.payroll.payroll_service.domain;

public class YearlyFinancialReport {
	private String Event;
	private String EmpID;
	private String EventDate;
	private String Value;

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEmpID() {
		return EmpID;
	}

	public void setEmpID(String empID) {
		EmpID = empID;
	}

	public String getEventDate() {
		return EventDate;
	}

	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	@Override
	public String toString() {
		return "YearlyFinancialReport [Event=" + Event + ", EmpID=" + EmpID + ", EventDate=" + EventDate + ", Value="
				+ Value + "]";
	}

}
