package com.learning.management.system.cart.exceptions;

/**
 * This exception class will throw all exceptions occurred while validating request.
 */
public class ValidationException extends CourseManagementException {

    public ValidationException(String msg){
        super(msg);
    }

    public ValidationException(String msg , Throwable th){
        super(msg , th);
    }

}
