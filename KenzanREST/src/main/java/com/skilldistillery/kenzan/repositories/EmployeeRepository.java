package com.skilldistillery.kenzan.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.kenzan.entitites.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
