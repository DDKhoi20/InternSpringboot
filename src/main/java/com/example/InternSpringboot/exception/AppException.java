package com.example.InternSpringboot.exception;

import com.example.InternSpringboot.enums.ErrorCode;

public class AppException extends RuntimeException{
    public AppException(ErrorCode errorCode){
        super(errorCode.getMesseage());
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
