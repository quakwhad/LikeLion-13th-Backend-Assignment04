package com.likelion.likelionassignmentcrud.employee.application;

import com.likelion.likelionassignmentcrud.department.domain.Department;
import com.likelion.likelionassignmentcrud.department.domain.repository.DepartmentRepository;
import com.likelion.likelionassignmentcrud.employee.api.dto.request.EmployeeSaveRequestDto;
import com.likelion.likelionassignmentcrud.employee.api.dto.request.EmployeeUpdateRequestDto;
import com.likelion.likelionassignmentcrud.employee.api.dto.response.EmployeeInfoResponseDto;
import com.likelion.likelionassignmentcrud.employee.api.dto.response.EmployeeListResponseDto;
import com.likelion.likelionassignmentcrud.employee.domain.Employee;
import com.likelion.likelionassignmentcrud.employee.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    // 직원 저장
    @Transactional
    public void employeeSave(EmployeeSaveRequestDto employeeSaveRequestDto) {
        Department department = departmentRepository.findById(employeeSaveRequestDto.departmentId()).orElseThrow(IllegalAccessError::new);

        Employee employee = Employee.builder()
                .name(employeeSaveRequestDto.name())
                .age(employeeSaveRequestDto.age())
                .responsibilities(employeeSaveRequestDto.responsibilities())
                .department(department)
                .build();

        employeeRepository.save(employee);
    }

    // 특정 부서의 직원 목록 조회
    public EmployeeListResponseDto employeeFindDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(IllegalArgumentException::new);

        List<Employee> employees = employeeRepository.findByDepartment(department);
        List<EmployeeInfoResponseDto> employeeInfoResponseDtos = employees.stream()
                .map(EmployeeInfoResponseDto::from)
                .toList();

        return EmployeeListResponseDto.from(employeeInfoResponseDtos);
    }

    // 직원 수정
    @Transactional
    public void employeeUpdate(Long employeeId, EmployeeUpdateRequestDto employeeUpdateRequestDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(IllegalArgumentException::new);

        employee.update(employeeUpdateRequestDto);
    }

    // 직원 삭제
    @Transactional
    public void employeeDelete(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(IllegalArgumentException::new);

        employeeRepository.delete(employee);
    }
}
