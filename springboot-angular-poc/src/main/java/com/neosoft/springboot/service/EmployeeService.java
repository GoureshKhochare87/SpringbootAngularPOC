package com.neosoft.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.dto.ResultModel;
import com.neosoft.springboot.model.Employee;
import com.neosoft.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired 
private EmployeeRepository employeeRepository;
public ResultModel createEmployeeTest(Employee employee){
	employeeRepository.save(employee);
	return new ResultModel("Employee with Name : "+employee.getFirstName()+" and ID: "+employee.getEmployeeId()+" saved ",Boolean.TRUE,"Success");
}
public ResultModel getEmployeeByTest() {
	List<Employee> employee=employeeRepository.findAll();
	if(employee.size()==0) {
		return new ResultModel("No Employee were Found",Boolean.FALSE,"Failed");
	}
	else {
		return new ResultModel("Number of Employees were Found are "+employee.size(),Boolean.TRUE,"Success");
	}
}


public ResultModel getEmployeeByIdTest(Integer employeeId) {
	List<Employee> employee=employeeRepository.findByEmployeeId(employeeId);
	if(employee.size()==0) {
		return new ResultModel("No Employee with ID: "+employeeId+" were Found",Boolean.FALSE,"Failed");
	}
	else {
		return new ResultModel("Number of Employees with ID: "+employeeId+" were Found are "+employee.size(),Boolean.TRUE,"Success");
	}
}
public ResultModel updateEmployeeTest(Employee employee, Integer employeeId) {
	Employee employeeData=employeeRepository.findEmployeeByEmployeeId(employeeId);
	if(employeeData==null) {
		return new ResultModel("No Employee with ID: "+employeeId+" were Found",Boolean.FALSE,"Failed");
	}
	else {
		employeeData.setFirstName(employee.getFirstName());
		employeeData.setLastName(employee.getLastName());
		employeeData.setEmailId(employee.getEmailId());
		employeeData.setMobileNo(employee.getMobileNo());
		employeeData.setCity(employee.getCity());
		employeeData.setCountry(employee.getCountry());
		employeeRepository.save(employeeData);
		return new ResultModel("Employee with ID: "+employeeId+" is Updated Succesfully ",Boolean.TRUE,"Success");
	}
}
public ResultModel deleteEmployeeTest(Integer employeeId) {
	Employee employee=employeeRepository.findEmployeeByEmployeeId(employeeId);
	if(employee==null) {
		return new ResultModel("No Employee with ID: "+employeeId+" were Found",Boolean.FALSE,"Failed");
	}
	else {
		employeeRepository.delete(employee);
		return new ResultModel("Employee with ID: "+employeeId+" is Deleted Succesfully ",Boolean.TRUE,"Success");
		
	}
}

public ResultModel getEmployeeByNameTest(String firstName) {
	List<Employee> employee=employeeRepository.findByFirstName(firstName);
	if(employee.size()==0) {
		return new ResultModel("No Employee with First Name "+firstName+" were Found",Boolean.FALSE,"Failed");
	}
	else {
		return new ResultModel("Number of Employee with First Name "+firstName+" were Found are "+employee.size(),Boolean.TRUE,"Success");
	}
}
}