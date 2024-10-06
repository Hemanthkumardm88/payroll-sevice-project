package com.payroll.payroll_service.domain;

public class MonthlyEmployeeData {
	private String EmpID;
	private String EmpFName;
	private String EmpLName;
	private String Designation;
	private String EventDate;

	public String getEmpID() {
		return EmpID;
	}

	public void setEmpID(String empID) {
		EmpID = empID;
	}

	public String getEmpFName() {
		return EmpFName;
	}

	public void setEmpFName(String empFName) {
		EmpFName = empFName;
	}

	public String getEmpLName() {
		return EmpLName;
	}

	public void setEmpLName(String empLName) {
		EmpLName = empLName;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getEventDate() {
		return EventDate;
	}

	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}

	@Override
	public String toString() {
		return "MonthlyEmployeeData [EmpID=" + EmpID + ", EmpFName=" + EmpFName + ", EmpLName=" + EmpLName
				+ ", Designation=" + Designation + ", EventDate=" + EventDate + "]";
	}

}
