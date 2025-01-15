package com.neeraj.HPE.Project.service;

import com.neeraj.HPE.Project.model.Employee;
import com.neeraj.HPE.Project.repo.Employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeManagerTest {
     @Mock
     private Employees employees;
     @InjectMocks
    private EmployeeManager employeeManager;

     @Test
    public void getAllEmployeesTest(){
         List<Employee> mockEmployees = Arrays.asList(
                 new Employee(1,"John","Doe","johndoe@example.com", "Developer"),
                 new Employee(2,"Jane","Smith","jane.smith@example.com", "Designer")
         );
         when(employees.findAll()).thenReturn(mockEmployees);

         // Act: Call the method under test
         List<Employee> result = employeeManager.getAllEmployees();

         // Assert: Verify the results
         assertEquals(2, result.size());
         assertEquals("John", result.get(0).getFirstName());
         assertEquals("Jane", result.get(1).getFirstName());

         // Verify the interaction with the mocked repository
         verify(employees, times(1)).findAll();
     }

    @Test
    public void getEmployeeByIdTest() {
        // Arrange
        int employeeId = 1;
        Employee mockEmployee = new Employee(1, "John", "Doe", "johndoe@example.com", "Developer");
        when(employees.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        // Act
        Optional<Employee> result = employeeManager.getEmployeeById(employeeId);

        // Assert
        assertTrue(result.isPresent(), "Employee should be present");
        assertEquals("John", result.get().getFirstName());
        assertEquals("Doe", result.get().getLastName());
        assertEquals("johndoe@example.com", result.get().getEmail());
        assertEquals("Developer", result.get().getTitle());

        // Verify interaction with the mock
        verify(employees).findById(employeeId);
    }

    @Test
    public void addEmployeeTest() {
        // Arrange
        Employee newEmployee = new Employee(1, "John", "Doe", "johndoe@example.com", "Developer");
        when(employees.save(newEmployee)).thenReturn(newEmployee);

        // Act
        Employee result = employeeManager.addEmployee(newEmployee);

        // Assert
        assertEquals(newEmployee, result, "The returned employee should match the saved employee");
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("johndoe@example.com", result.getEmail());
        assertEquals("Developer", result.getTitle());

        // Verify interaction with the mock
        verify(employees, times(1)).save(newEmployee);
    }

    @Test
    public void deleteEmployeeTest() {
        // Arrange
        int employeeId = 1;

        // Act
        employeeManager.deleteEmployee(employeeId);

        // Assert
        // Verify that deleteById is called once with the correct ID
        verify(employees, times(1)).deleteById(employeeId);
    }
}

