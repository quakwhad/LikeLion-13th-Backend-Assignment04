package com.likelion.likelionassignmentcrud.employee.api.dto.request;

import com.likelion.likelionassignmentcrud.department.domain.Part;

public record EmployeeSaveRequestDto(
        // @NotNull(message = "부서는 필수로 입력해야합니다.") // departmentId는 필수
        Long departmentId,
        // @NotBlank(message = "이름은 필수로 입력해야 합니다.")
        // @Size(min = 2, max = 10)    // 최소 2글자, 최대 10글자
        String name,

        int age,

        // @NotBlank(message = "직급은 필수로 입력해야 합니다.")
        String responsibilities,

        Part part
) {
}
