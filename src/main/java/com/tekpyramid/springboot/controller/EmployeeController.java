package com.tekpyramid.springboot.controller;

import com.tekpyramid.springboot.entity.Address;
import com.tekpyramid.springboot.entity.Employee;
import com.tekpyramid.springboot.entity.Technology;
import com.tekpyramid.springboot.response.ApiResponse;
import com.tekpyramid.springboot.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-employee")
    public ResponseEntity<ApiResponse> mockEmployee(){

        ApiResponse apiResponse=new ApiResponse();

        Employee employee=new Employee();
        Address address=new Address();
        Technology technology1=new Technology();
        Technology technology2=new Technology();

        technology1.setTechName("Java");
        technology2.setTechName("Python");

        List<Technology> technologies=new ArrayList<>();

        technologies.add(technology1);
        technologies.add(technology2);


        address.setCity("Chennai");
        address.setState("Tamil Nadu");
        address.setCountry("India");
        address.setStreetName("Rajaji Nagar");

        List<Address> addresses=new ArrayList<>();
        addresses.add(address);

        employee.setEmployeeId(1);
        employee.setEmployeeName("Raj");
        employee.setPhone(64446L);
        employee.setGender("Male");
        employee.setDateOfBirth(LocalDate.of(1999,11,21));

        employee.setTechnologies(technologies);
        address.setEmployee(employee);
        employee.setAddress(addresses);


        apiResponse.setData(employee);
        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("Data fetched successfully");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);

    }

    @PostMapping("/save-employee")
    public ResponseEntity<?> saveEmployee(@RequestBody @Valid Employee employee){

       String id=employeeService.save(employee);

       ApiResponse apiResponse=new ApiResponse();
        apiResponse.setData(id);
        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("Data saved successfully");

       return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);

    }

    public ResponseEntity<?> findByEmail(@PathVariable String email){

     Employee employee = employeeService.findByEmail(email);

        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setData(employee);
        apiResponse.setHttpStatus(HttpStatus.FOUND);
        apiResponse.setMessage("Data saved successfully");

        return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);


    }


}
