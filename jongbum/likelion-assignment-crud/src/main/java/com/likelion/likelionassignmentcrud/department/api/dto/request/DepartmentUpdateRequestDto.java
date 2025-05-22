package com.likelion.likelionassignmentcrud.department.api.dto.request;

import com.likelion.likelionassignmentcrud.department.domain.Part;

public record DepartmentUpdateRequestDto(
        // 업데이트할 변수 입력
        String name,
        Part part
) {
}
