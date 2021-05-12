package com.neosoft.springboot.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.dto.ResultModel;
import com.neosoft.springboot.exception.ResourceNotFoundException;
import com.neosoft.springboot.model.Employee;
import com.neosoft.springboot.repository.EmployeeRepository;
import com.neosoft.springboot.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	// get all employees
	@GetMapping("/employeestest")
	public ResultModel getAllEmployeesTest(){
		logger.info("Inside getAllEmployeesTest");
		return employeeService.getEmployeeByTest();
	}		
	
	// create employee rest api
	@PostMapping("/employeestest")
	public ResultModel createEmployeeTest(@Valid @RequestBody Employee employee) {
		logger.info("Inside createEmployeeTest");
		return employeeService.createEmployeeTest(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employeestest/{id}")
	public ResultModel getEmployeeByIdTest(@Valid @PathVariable Integer id) {
		logger.info("Inside getEmpoyeeByIdTest");
		return employeeService.getEmployeeByIdTest(id);
	}
	
	// update employee rest api
	
	@PutMapping("/employeestest/{id}")
	public ResultModel updateEmployeeTest(@Valid @PathVariable Integer id,@RequestBody Employee employeeDetails){
		logger.info("Inside updateEmployeeTest");
		return employeeService.updateEmployeeTest(employeeDetails, id);
	}
	
	// delete employee rest api
	@DeleteMapping("/employeestest/{id}")
	public ResultModel deleteEmployeeTest(@Valid @PathVariable Integer id){
		logger.info("Inside deleteEmployeeTest");
		return employeeService.deleteEmployeeTest(id);
	}
	
	@GetMapping("/employeesnametest/{firstName}")
	public ResultModel getEmployeeByNameTest(@Valid @PathVariable String firstName) {
		logger.info("Inside getEmployeeByNameTest");
		return employeeService.getEmployeeByNameTest(firstName);
	}
	//======================================================================
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		logger.info("Inside getAllEmployees");
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		logger.info("Inside createEmployee");
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@Valid @PathVariable Integer id) {
		logger.info("Inside getEmployeeById");
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable Integer id, @RequestBody Employee employeeDetails){
		logger.info("Inside updateEmployee");
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setMobileNo(employeeDetails.getMobileNo());
		employee.setCity(employeeDetails.getCity());
		employee.setCountry(employeeDetails.getCountry());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@Valid @PathVariable Integer id){
		logger.info("Inside deleteEmployee");
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/employeesname/{firstName}")
	public List<Employee> getEmployeeByName(@Valid @PathVariable (value="firstName") String firstName){
		logger.info("Inside getEmployeeByName");
		return employeeRepository.findByFirstName(firstName);
	}
	
}
