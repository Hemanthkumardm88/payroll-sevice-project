Payroll Processing System - PPC
This project provides APIs to onboard employees, manage their salaries, track exits, and generate various financial reports for a payroll processing system.

Prerequisites
Java 17 or later
Maven 3.x
H2 Database (embedded)
Spring Boot
How to Run the Application


mvn clean install  on project directory
Run the application:
		1. By running main class in IDE 
		2. java -jar application.jar 
		
		java -jar target/payroll-processing-system-0.0.1-SNAPSHOT.jar


You can run the Spring Boot application using Maven or directly from your IDE.

API Endpoints
Below is a list of available API endpoints:

1. Upload Employee Details File
	Endpoint: /api/employees/upload

	Method: POST

	Description: Upload a text file containing employee onboarding, salary, and exit details. The file should follow the format described in the input example.

	Request:

	Content-Type: multipart/form-data
	Parameter: file (Text file with employee details)

	curl -X POST http://localhost:8080/api/employees/upload -F 'file=@Employee_details.txt'


	Response: Success or failure message after processing the file.

2. Get Total Number of Employees
	Endpoint: /api/employees/total

	Method: GET

	Description: Fetch the total number of employees in the organization.

	Response:
	{
	  "totalEmployees": 100
	}


3. Get Monthly Join/Exit Report
	Endpoint: /api/reports/monthly-employees

	Method: GET

	Description: Fetch a month-wise report of employees who joined and exited the organization.

	Response:

	{
	  "month": "October 2022",
	  "joined": [
		{
		  "empId": "emp102",
		  "name": "Steve",
		  "surname": "Jobs",
		  "designation": "Architect"
		}
	  ],
	  "exited": [
		{
		  "name": "Martin",
		  "surname": "Fowler"
		}
	  ]
	}


4. Get Monthly Salary Report
	Endpoint: /api/reports/salary/monthly

	Method: GET

	Description: Fetch a report for the total monthly salary disbursement.

	Response:

	
	{
	  "month": "October 2022",
	  "totalSalary": 5000,
	  "totalEmployees": 10
	}


5. Get Employee Financial Report
	Endpoint: /api/reports/financial/employee/{empId}

	Method: GET

	Description: Get the financial report for a specific employee.

	Response:

	{
	  "empId": "emp102",
	  "name": "Steve",
	  "surname": "Jobs",
	  "totalAmountPaid": 4500
	}


6. Get Monthly Amount Released (Salary + Bonus + Reimbursement)
	Endpoint: /api/reports/financial/monthly

	Method: GET

	Description: Get the total amount released in a month, including salary, bonus, and reimbursement.

	Response:

	{
	  "month": "October 2022",
	  "totalAmountReleased": 10000,
	  "totalEmployees": 15
	}


7. Get Yearly Financial Report
	Endpoint: /api/reports/financial/yearly

	Method: GET

	Description: Get a yearly financial report detailing the events like employee onboarding, salary payments, and exits.

	Response:

	{
	  "event": "ONBOARD",
	  "empId": "emp101",
	  "eventDate": "2022-11-01",
	  "eventValue": "Onboarded as Software Engineer"
	},
	{
	  "event": "SALARY",
	  "empId": "emp102",
	  "eventDate": "2022-10-10",
	  "eventValue": 3000
	}


Input File Format
The text file should be structured as follows:
1, emp101, Bill, Gates, Software Engineer, ONBOARD, 1-11-2022, 10-10-2022, “Bill Gates is going to join DataOrb on 1st November as a SE.”
2, emp102, Steve, Jobs, Architect, ONBOARD, 1-10-2022, 10-10-2022, “Steve Jobs joined DataOrb on 1st October as an Architect.”
3, emp103, Martin, Fowler, Software Engineer, ONBOARD, 15-10-2022, 10-10-2022, “Martin has joined DataOrb as a SE.”
4, emp102, SALARY, 3000, 10-10-2022, “Oct Salary of Steve.”


The following types of events can be present in the input file:

	ONBOARD: Employee onboarding event
	SALARY: Salary payment event
	EXIT: Employee exit event
Technologies Used
	Java 17
	Spring Boot
	H2 In-Memory Database
	Spring Data JPA
	maven


