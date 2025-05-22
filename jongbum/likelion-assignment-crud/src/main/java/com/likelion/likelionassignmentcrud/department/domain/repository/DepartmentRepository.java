package com.likelion.likelionassignmentcrud.department.domain.repository;

import com.likelion.likelionassignmentcrud.department.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
