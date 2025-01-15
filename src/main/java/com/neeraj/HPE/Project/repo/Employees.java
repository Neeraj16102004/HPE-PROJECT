package com.neeraj.HPE.Project.repo;
import com.neeraj.HPE.Project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employees extends JpaRepository<Employee, Integer> {

}
