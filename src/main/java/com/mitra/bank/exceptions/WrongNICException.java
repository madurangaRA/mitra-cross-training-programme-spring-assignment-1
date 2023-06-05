package com.mitra.bank.exceptions;
import org.springframework.http.HttpStatus;

import java.io.Serial;


public class WrongNICException extends AccountException {
    @Serial
    private static final long serialVersionUID = 1L;
    public WrongNICException(String errorCode, String message, HttpStatus httpStatusCode) {
        super(errorCode, message, httpStatusCode);
    }

}
