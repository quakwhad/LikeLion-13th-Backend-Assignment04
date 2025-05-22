package com.likelion.likelionassignmentcrud.employee.domain.repository;

import com.likelion.likelionassignmentcrud.department.domain.Department;
import com.likelion.likelionassignmentcrud.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(Department department);
}
