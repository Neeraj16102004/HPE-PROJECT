package com.neeraj.HPE.Project.controller;

import com.neeraj.HPE.Project.model.Employee;
import com.neeraj.HPE.Project.service.EmployeeManager;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employees")
@Data
public class EmployeeController {
      private final EmployeeManager employeeManager;
      @Autowired
      public EmployeeController(EmployeeManager employeeManager){
          this.employeeManager = employeeManager;
      }
    @GetMapping("")
    public List<Employee> getAllEmployees(){
          return employeeManager.getAllEmployees();
      }
   @GetMapping("/{employeeId}")
    public Optional<Employee> getById(@PathVariable int employeeId){
          return employeeManager.getEmployeeById(employeeId);
    }
  @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
          return employeeManager.addEmployee(employee);
  }
  @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
           employeeManager.deleteEmployee(employeeId);
  }
}
