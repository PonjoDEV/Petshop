package org.edu.ifmg.client.exception;

import org.edu.ifmg.client.utility.ApiResponseCode;

import lombok.Getter;

@Getter
public class DefaultException extends RuntimeException {
    private String message;
    private ApiResponseCode code = ApiResponseCode.BAD_REQUEST;
    protected Object details;


    public DefaultException (){
        this("Generic Exception");
    }

    public DefaultException (String message){
        this(message,null);
    }
    
    public DefaultException (String message, Object details){
        super(message);
        this.details=details;
    }

    public DefaultException (String message, ApiResponseCode code, Object details){
        super(message);
        this.message=message;
        this.details=details;
        this.code=code;
    }
}

