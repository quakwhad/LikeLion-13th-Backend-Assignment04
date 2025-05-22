package com.likelion.likelionassignmentcrud.common.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {
    
    // 404 NOT FOUND
    DEPARTMENT_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 부서가 존재하지 않습니다"),
    EMPLOYEE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 직원이 존재하지 않습니다"),

    // 400 BAD REQUEST
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "유효성 검사에 실패했습니다."),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류가 발생했습니다");

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;

    public int getHttpStatusCode() { return httpStatus.value(); }
    
}
