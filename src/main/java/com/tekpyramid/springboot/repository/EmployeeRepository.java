package com.tekpyramid.springboot.repository;

import com.tekpyramid.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


     Employee findByEmail(String email);
}
