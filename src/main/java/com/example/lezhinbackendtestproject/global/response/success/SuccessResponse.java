package com.example.lezhinbackendtestproject.global.response.success;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Getter
@Slf4j
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse {
    private int status;
    private Object responseObject;
    private String responseMessage;
    private String path;

    private SuccessResponse(final @NotNull SuccessCode successCode, Object responseObject) {
        this.status = successCode.getHttpStatus().value();
        this.responseMessage = successCode.getMessage();
        this.responseObject = responseObject;
    }

    public static ResponseEntity<SuccessResponse> toResponseEntity (final @NotNull SuccessCode successCode,
                                                                    final @NotNull Object responseObject) {

        log.info("Success Response - success code : {}, success responseObject : {}",
                successCode.getSuccessCode(), successCode.getMessage());

        return ResponseEntity
                .status(successCode.getHttpStatus())
                .body(new SuccessResponse(successCode, responseObject));
    }
    public static ResponseEntity<SuccessCode> toResponseEntityForAjax (final @NotNull SuccessCode successCode) {
        log.info("Success Response - success code : {}, success message : {}",
                successCode.getSuccessCode(), successCode.getMessage());

        return ResponseEntity.ok().body(successCode);
    }

}
