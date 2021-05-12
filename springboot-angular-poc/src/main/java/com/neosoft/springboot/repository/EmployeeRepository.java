package com.neosoft.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.springboot.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer>{
List<Employee> findByEmployeeId(Integer employeeId);
public Employee findEmployeeByEmployeeId(Integer employeeId);
List<Employee> findByFirstName(String firstName);
//List<Employee> findByEmployeePinCode(String userPinCode);
//public Employee findByEmployeeContact(String userContact);
//public Employee findByEmployeeEmail(String userEmail);
}