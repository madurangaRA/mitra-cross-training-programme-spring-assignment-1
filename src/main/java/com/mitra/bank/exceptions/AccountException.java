package com.mitra.bank.exceptions;

import java.io.Serial;
import java.util.Date;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AccountException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("timestamp")
    private final long timestamp;
    @JsonProperty("error_code")
    private final String errorCode;
    @JsonProperty("message")
    private final String message;
    private final HttpStatus httpStatusCode;

    public AccountException(String errorCode, String message, HttpStatus httpStatusCode) {
        super(message);
        this.timestamp = new Date().getTime();
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

}
