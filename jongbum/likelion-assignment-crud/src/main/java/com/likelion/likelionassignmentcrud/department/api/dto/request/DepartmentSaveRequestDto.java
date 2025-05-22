package com.likelion.likelionassignmentcrud.department.api.dto.request;

import com.likelion.likelionassignmentcrud.department.domain.Part;

public record DepartmentSaveRequestDto(
        String name,
        Part part
) {
}
