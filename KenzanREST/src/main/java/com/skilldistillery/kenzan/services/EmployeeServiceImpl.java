package com.skilldistillery.kenzan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.kenzan.entitites.Employee;
import com.skilldistillery.kenzan.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> listAll() {
		List<Employee> employees = repo.findAll();
		return employees;
	}

	@Override
	public List<Employee> listAllEmployees() {
		List<Employee> employees = repo.findAll();
		List<Employee> employeeOut = new ArrayList<Employee>();
		for (Employee e : employees) {
			Optional<Employee> employeeOpt = repo.findById(e.getId());
			if (employeeOpt.isPresent()) {
				Employee employee = employeeOpt.get();
				if (employee.isStatus() == true) {
					employeeOut.add(employee);
				}
			}
		}
		return employeeOut;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Optional<Employee> employeeOpt = repo.findById(id);
		if (employeeOpt.isPresent()) {
			Employee employee = employeeOpt.get();
			if (employee.isStatus() == true) {
				return employee;
			}
		}
		return null;

	}

	@Override
	public Employee createNewEmployee(Employee employee) {

		repo.saveAndFlush(employee);

		return employee;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> employeeOpt = repo.findById(id);
		Employee employeeToUpdate = null;
		if (employeeOpt.isPresent()) {
			employeeToUpdate = employeeOpt.get();
			if (employee.getFirstName() != null) {
				employeeToUpdate.setFirstName(employee.getFirstName());
			}
			if (employee.getMiddleInitial() != null) {
				employeeToUpdate.setMiddleInitial(employee.getMiddleInitial());
			}
			if (employee.getLastName() != null) {
				employeeToUpdate.setLastName(employee.getLastName());
			}
			if (employee.getDob() != null) {
				employeeToUpdate.setDob(employee.getDob());
			}
			if (employee.getDoe() != null) {
				employeeToUpdate.setDoe(employee.getDoe());
			}
			employeeToUpdate.setStatus(employee.isStatus());

			repo.flush();
		}
		return employeeToUpdate;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean deleted = false;
		Optional<Employee> employeeOpt = repo.findById(id);
		if (employeeOpt.isPresent()) {
			Employee employee = employeeOpt.get();
			employee.setStatus(false);
			if (employee.isStatus() == false) {
				deleted = true;
			}
		}
		return deleted;

	}
}
