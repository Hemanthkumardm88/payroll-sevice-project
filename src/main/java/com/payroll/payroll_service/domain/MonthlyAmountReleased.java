package com.payroll.payroll_service.domain;

public class MonthlyAmountReleased {

	private String EventDate;
	private Double TotalAmount;
	private int TotalEmployees;

	public String getEventDate() {
		return EventDate;
	}

	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}

	public Double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}

	public int getTotalEmployees() {
		return TotalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		TotalEmployees = totalEmployees;
	}

	@Override
	public String toString() {
		return "MonthlyAmountReleased [EventDate=" + EventDate + ", TotalAmount=" + TotalAmount + ", TotalEmployees="
				+ TotalEmployees + "]";
	}

}
