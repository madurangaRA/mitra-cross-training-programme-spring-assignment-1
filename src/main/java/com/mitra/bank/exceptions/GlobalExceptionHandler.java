package com.mitra.bank.exceptions;

import java.util.Date;

import com.mitra.bank.service.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AccountException.class})
    public ResponseEntity<ErrorResponse> handleDispatcherException(AccountException exception) {
        log.info(exception.getMessage(), exception);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(new Date())
                .errorCode(exception.getErrorCode())
                .message(exception.getMessage()).build();
        return new ResponseEntity<>(errorResponse, exception.getHttpStatusCode());
    }
}
