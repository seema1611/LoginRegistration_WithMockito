package com.loginregistration.model;

public class ResponseDto {
    private Object data;
    private String message;
    private Integer statusCode;

    public ResponseDto(Object data, String message, Integer statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
