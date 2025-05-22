package com.likelion.likelionassignmentcrud.department.api;

import com.likelion.likelionassignmentcrud.common.error.SuccessCode;
import com.likelion.likelionassignmentcrud.common.template.ApiResTemplate;
import com.likelion.likelionassignmentcrud.department.api.dto.request.DepartmentSaveRequestDto;
import com.likelion.likelionassignmentcrud.department.api.dto.request.DepartmentUpdateRequestDto;
import com.likelion.likelionassignmentcrud.department.api.dto.response.DepartmentInfoResponseDto;
import com.likelion.likelionassignmentcrud.department.api.dto.response.DepartmentListResponseDto;
import com.likelion.likelionassignmentcrud.department.application.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    // 부서 저장
    @PostMapping("/save")
    public ApiResTemplate<String> departmentSave(@RequestBody DepartmentSaveRequestDto departmentSaveRequestDto) {
        departmentService.departmentSave(departmentSaveRequestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.DEPARTMENT_SAVE_SUCCESS);
    }
    
    // 부서 전체 조회
    @GetMapping("/all")
    public ApiResTemplate<DepartmentListResponseDto> departFindAll() {
        DepartmentListResponseDto departmentListResponseDto = departmentService.departmentFindAll();

        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, departmentListResponseDto);
    }

    // 부서 id를 통해 특정 부서 조회
    @GetMapping("/{departmentId}")
    public ApiResTemplate<DepartmentInfoResponseDto> departmentFindOne(@PathVariable("departmentId") Long departmentId) {
        DepartmentInfoResponseDto departmentInfoResponseDto = departmentService.departmentFindOne(departmentId);
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, departmentInfoResponseDto);
    }

    // 부서 id를 통한 부서 수정
    @PatchMapping("/{departmentId}")
    public ResponseEntity<String> depratmentUpdate(
            @PathVariable("departmentId") Long departmentId,
            @RequestBody DepartmentUpdateRequestDto departmentUpdateRequestDto) {
        departmentService.departmentUpdate(departmentId, departmentUpdateRequestDto);
        return new ResponseEntity<>("부서 수정", HttpStatus.OK);
    }


    // 부서 id를 통한 삭제
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> departmentDelete(
            @PathVariable("departmentId") Long departmentId) {
        departmentService.departmentDelete(departmentId);
        return new ResponseEntity<>("부서 삭제", HttpStatus.OK);
    }
}
