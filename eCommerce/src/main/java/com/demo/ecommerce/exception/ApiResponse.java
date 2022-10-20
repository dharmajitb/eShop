package com.demo.ecommerce.exception;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class ApiResponse {
    private String message,token;
    HashMap<String,String> data=null;

    private List<String> errors;
    public ApiResponse( String message, List<String> errors) {
        super();
        //this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiResponse( HashMap<String,String> data,String token) {
        this.data = data;
        this.token = token;
    }

    public ApiResponse( String token,String message, List<String> errors) {
        super();
        this.token = token;
        this.message = message;
        this.errors = errors;
    }

    public ApiResponse( String message, String error) {
        super();
        //this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
//	    public ApiResponse( String message, String Reason,String error_code) {
//	        super();
//	        //this.status = status;
//	        this.message = message;
//	        errors = Arrays.asList(error);
//	    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public HashMap<String, String> getData() {
        return data;
    }
    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
}
