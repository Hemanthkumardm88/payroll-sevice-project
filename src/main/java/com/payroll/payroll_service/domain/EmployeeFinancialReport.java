package com.payroll.payroll_service.domain;

public class EmployeeFinancialReport {

	private String EmpID;
	private String EmpFName;
	private String EmpLName;
	private Double TotalPaid;

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

	public Double getTotalPaid() {
		return TotalPaid;
	}

	public void setTotalPaid(Double totalPaid) {
		TotalPaid = totalPaid;
	}

	@Override
	public String toString() {
		return "EmployeeFinancialReport [EmpID=" + EmpID + ", EmpFName=" + EmpFName + ", EmpLName=" + EmpLName
				+ ", TotalPaid=" + TotalPaid + "]";
	}

}
