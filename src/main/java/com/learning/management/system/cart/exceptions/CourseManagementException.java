package com.learning.management.system.cart.exceptions;

public class CourseManagementException extends Exception {

    public CourseManagementException(){
        super();
    }

    public CourseManagementException(String msg){
        super(msg);
    }

    public CourseManagementException(String msg , Throwable th){
        super(msg , th);
    }
}
