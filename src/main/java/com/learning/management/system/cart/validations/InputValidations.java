package com.learning.management.system.cart.validations;

import com.learning.management.system.cart.exceptions.ValidationException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InputValidations implements ValidationEngine {

    @Override
    public void validate(RequestedCourse requestedCourse, List<ValidationException> errors) {
        String courseId = requestedCourse.getCourseId();
        if(courseId== null || courseId.isEmpty()){
            errors.add(new ValidationException("Invalid Course id provided :: " + courseId));
        }

        String currency = requestedCourse.getCurrency();
        if(currency == null ||  currency.isEmpty()){
            errors.add(new ValidationException("Invalid currency  provided :: " + currency));
        }
    }
}
