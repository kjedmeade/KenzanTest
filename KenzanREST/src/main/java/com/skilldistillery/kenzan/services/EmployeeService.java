package com.skilldistillery.kenzan.services;

import java.util.List;

import com.skilldistillery.kenzan.entitites.Employee;

public interface EmployeeService {

	Employee findEmployeeById(int id);

	Employee createNewEmployee(Employee employee);

	Employee updateEmployee(int id, Employee employee);

	boolean deleteEmployee(int id);

	List<Employee> listAllEmployees();

	List<Employee> listAll();

}
