package com.arrisdev.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailExistException extends RuntimeException{

    private String msg;

    public EmailExistException(String msg){
        super(msg);
    }
}
