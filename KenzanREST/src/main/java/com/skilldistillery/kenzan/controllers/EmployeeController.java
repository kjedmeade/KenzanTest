package com.skilldistillery.kenzan.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.kenzan.entitites.Employee;
import com.skilldistillery.kenzan.services.EmployeeService;

@CrossOrigin({ "*", "http://localhost:4205" })
@RequestMapping("api")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService pBServ;

	@GetMapping("employees/all")
	public List<Employee> listAll(HttpServletResponse response) {
		List<Employee> employees = pBServ.listAll();
		if (employees == null) {
			response.setStatus(404);
		}
		return employees;
	}
	
	@GetMapping("employees")
	public List<Employee> listAllEmployees(HttpServletResponse response) {
		List<Employee> employees = pBServ.listAllEmployees();
		if (employees == null) {
			response.setStatus(404);
		}
		return employees;
	}

	@GetMapping("employees/{id}")
	public Employee listEmployeeById(@PathVariable Integer id, HttpServletResponse response) {
		Employee employee = pBServ.findEmployeeById(id);
		if (employee == null) {
			response.setStatus(404);
		}
		return employee;
	}

	@PostMapping("employees")
	public Employee createNewEmployee(@RequestBody Employee employee, HttpServletResponse response,
			HttpServletRequest request) {
		employee = pBServ.createNewEmployee(employee);
		if (employee == null) {
			response.setStatus(404);
		} else {
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(employee.getId());
			response.setHeader("Location", url.toString());

		}
		return employee;
	}

	@PutMapping("employees/{id}")
	public Employee updatePost(@RequestBody Employee employee, @PathVariable int id, HttpServletResponse response) {
		employee = pBServ.updateEmployee(id, employee);
		try {
			if (employee == null) {

				response.setStatus(404);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(400);
			employee = null;
		}
		return employee;
	}

	@DeleteMapping("employees/{id}")
	public void deleteEmployee(@PathVariable Integer id, HttpServletResponse response) {
		try {

			boolean deleted = pBServ.deleteEmployee(id);
			if (deleted) {
				response.setStatus(204);
			} else {
				response.setStatus(404);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(400);
		}

	}
}
