package com.learning.management.system.cart.exceptions;

/**
 * This exception is used to wrap  all the exceptions occured due to  missing data in db.
 */
public class MissingDataException extends CourseManagementException {

    public MissingDataException(String  msg){
        super(msg);
    }

    public MissingDataException(String msg , Throwable th){
        super(msg , th);
    }
}
