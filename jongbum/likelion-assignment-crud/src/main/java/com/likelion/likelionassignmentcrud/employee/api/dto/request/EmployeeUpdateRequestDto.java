package com.likelion.likelionassignmentcrud.employee.api.dto.request;

public record EmployeeUpdateRequestDto(
        String name,
        int age,
        String responsibilities
) {
}
