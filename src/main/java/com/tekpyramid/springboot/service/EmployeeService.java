package com.tekpyramid.springboot.service;

import com.tekpyramid.springboot.entity.Address;
import com.tekpyramid.springboot.entity.Employee;
import com.tekpyramid.springboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public String save(Employee employee) {

        List<Address> addresses = employee.getAddress();


        for (Address address:addresses){

           address.setEmployee(employee);

        }


        return employeeRepository.save(employee).getEmployeeId()+"";

    }

    public Employee findByEmail(String email) {
       return employeeRepository.findByEmail(email);

    }
}
