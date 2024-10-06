package com.payroll.payroll_service.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface EmployeeFileService {

	void processEmployeeFile(MultipartFile file) throws IOException ;

}
