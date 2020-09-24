package org.mengsoft.webbackend.common.exceptions;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.enums.ResponseCode;

@Data
public class BusinessException extends RuntimeException{

    private Integer statusCode;
    private String message;

    public BusinessException(ResponseCode responseCode){
        this.statusCode = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

}
