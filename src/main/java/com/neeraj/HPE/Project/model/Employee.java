package com.neeraj.HPE.Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;




@Data
@Entity
public class Employee {




    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private int employeeId;
   private String  firstName;
   private String lastName;
   private String email;
   private String title;

   public Employee(int employeeId, String firstName, String lastName, String email, String title) {
      this.employeeId = employeeId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.title = title;
   }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}


