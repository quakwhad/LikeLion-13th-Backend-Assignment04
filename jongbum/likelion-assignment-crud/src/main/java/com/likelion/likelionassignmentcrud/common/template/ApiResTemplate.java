package com.likelion.likelionassignmentcrud.common.template;


import com.likelion.likelionassignmentcrud.common.error.ErrorCode;
import com.likelion.likelionassignmentcrud.common.error.SuccessCode;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)   // 모든 필드 값을 매개변수로 받는 생성자 자동 생성
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)  // 초기화되지 않는 final 붙은 필드만 매개변수로 받는 생성자 자동 생성
@Builder
// @JsonInclude(JsonInclude.Include.NON_NULL) // NULL 값은 무시
public class ApiResTemplate<T> {
    private final int code;         // 응답 코드
    private final String message;   // 응답 메세지
    private T data;                 // 응답 데이터

    // 데이터가 없는 성공 응답
    public static ApiResTemplate successWithNoContent(SuccessCode successCode) {
        return new ApiResTemplate<>(successCode.getHttpStatusCode(), successCode.getMessage());
    }

    // 데이터가 있는 성공 응답
    public static <T> ApiResTemplate<T> successResponse(SuccessCode successCode, T data) {
        return new ApiResTemplate<>(successCode.getHttpStatusCode(), successCode.getMessage(), data);
    }

    // 에러 응답  (메세지 포함)
    public static ApiResTemplate errorResponse(ErrorCode errorCode, String customMessage) {
        return new ApiResTemplate<>(errorCode.getHttpStatusCode(), customMessage);
    }

}
