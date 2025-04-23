package com.example.InternSpringboot.enums;

public enum ErrorCode {
    USER_EXISTED(1002, "User existed"),
    USER_NOT_EXISTED(1009, "User not existed"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncatogrized exception"),
    KEY_INVALID(1001, "Invalid messeage key"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters"),
    UNAUTHICATED(1007, "Unauthicated")
    ;

    ErrorCode(int code, String messeage) {
        this.code = code;
        this.messeage = messeage;
    }

    private int code;
    private String messeage;

    public int getCode() {
        return code;
    }

    public String getMesseage() {
        return messeage;
    }
}
