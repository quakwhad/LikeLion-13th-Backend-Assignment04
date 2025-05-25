package com.likelion.likelionassignmentcrud.employee.api;

import com.likelion.likelionassignmentcrud.common.error.SuccessCode;
import com.likelion.likelionassignmentcrud.common.template.ApiResTemplate;
import com.likelion.likelionassignmentcrud.employee.api.dto.request.EmployeeSaveRequestDto;
import com.likelion.likelionassignmentcrud.employee.api.dto.request.EmployeeUpdateRequestDto;
import com.likelion.likelionassignmentcrud.employee.api.dto.response.EmployeeInfoResponseDto;
import com.likelion.likelionassignmentcrud.employee.api.dto.response.EmployeeListResponseDto;
import com.likelion.likelionassignmentcrud.employee.application.EmployeeService;
import jakarta.validation.Valid;
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
    public ApiResTemplate<String> employeeSave(@RequestBody @Valid EmployeeSaveRequestDto employeeSaveRequestDto) {
        employeeService.employeeSave(employeeSaveRequestDto);

        return ApiResTemplate.successWithNoContent(SuccessCode.EMPLOYEE_SAVE_SUCCESS);
    }

    // 부서 id를 기준으로 해당 부서의 직원 조회
    @GetMapping("/{departmentId}")
    public ApiResTemplate<EmployeeListResponseDto> itsEmployeeFindAll(@PathVariable("departmentId") Long departmentId) {
        EmployeeListResponseDto employeeListResponseDto = employeeService.employeeFindDepartment(departmentId);
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, employeeListResponseDto);
    }

    // 직원 id를 통한 직원 수정
    @PatchMapping("/{employeeId}")
    public ApiResTemplate<String> employeeUpdate(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody @Valid EmployeeUpdateRequestDto employeeUpdateRequestDto) {
        employeeService.employeeUpdate(employeeId, employeeUpdateRequestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.EMPLOYEE_UPDATE_SUCCESS);
    }

    // 직원 id를 기준으로 직원 삭제
    @DeleteMapping("/{employeeId}")
    public ApiResTemplate<String> employeeDelete(
            @PathVariable("employeeId") Long employeeId) {
        employeeService.employeeDelete(employeeId);
        return ApiResTemplate.successWithNoContent(SuccessCode.EMPLOYEE_DELETE_SUCCESS);
    }
}
