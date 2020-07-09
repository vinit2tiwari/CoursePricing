package com.learning.management.system.cart.exceptions;

public class ApiException extends CourseManagementException {

    public ApiException(){
        super();
    }

    public ApiException(String msg){
        super(msg);
    }

    public ApiException(String msg , Throwable th){
        super(msg , th);
    }

}
