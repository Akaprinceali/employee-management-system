package com.tekpyramid.springboot.service;

import com.tekpyramid.springboot.entity.Employee;
import com.tekpyramid.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void testFindByEmail() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Setup
        Employee employee = new Employee();
        employee.setEmail("test@example.com");
        when(employeeRepository.findByEmail("test@example.com")).thenReturn(employee);

        // Execute
        Employee result = employeeService.findByEmail("test@example.com");

        // Verify
        assert result != null;
        assert "test@example.com".equals(result.getEmail());
    }

}
