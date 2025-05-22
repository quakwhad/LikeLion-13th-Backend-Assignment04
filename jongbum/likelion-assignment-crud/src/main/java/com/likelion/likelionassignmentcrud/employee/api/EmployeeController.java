package com.likelion.likelionassignmentcrud.employee.api;

import com.likelion.likelionassignmentcrud.employee.api.dto.request.EmployeeSaveRequestDto;
import com.likelion.likelionassignmentcrud.employee.api.dto.response.EmployeeListResponseDto;
import com.likelion.likelionassignmentcrud.employee.application.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    // 직원 저장
    @PostMapping("/save")
    public ResponseEntity<String> employeeSave(@RequestBody EmployeeSaveRequestDto employeeSaveRequestDto) {
        employeeService.employeeSave(employeeSaveRequestDto);

        return new ResponseEntity<>("직원 저장!", HttpStatus.CREATED);
    }

    // 부서 id를 기준으로 해당 부서의 직원 조회
    @GetMapping("/{departmentId}")
    public ResponseEntity<EmployeeListResponseDto> itsEmployeeFindAll(@PathVariable("departmentId") Long departmentId) {
        EmployeeListResponseDto employeeListResponseDto = employeeService.employeeFindDepartment(departmentId);
        return new ResponseEntity<>(employeeListResponseDto, HttpStatus.OK);
    }
}
