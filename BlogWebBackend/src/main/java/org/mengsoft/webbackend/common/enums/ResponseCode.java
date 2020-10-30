package org.mengsoft.webbackend.common.enums;



public enum ResponseCode {

    SUCCESS(200, "Success"),
    EMAIL_HAS_EXISTED(20001, "Email is already exsited!"),
    PARAM_IS_INVALID(20002, "Param is invalid."),
    USER_IS_NOT_EXISTED(20003, "User is not existed."),
    SYSTEM_ERROR(10000, "System Error, Please Contact Admin.");


    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
