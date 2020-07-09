package com.learning.management.system.cart.validations;

import com.learning.management.system.cart.exceptions.ValidationException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import java.util.List;

/**
 * This interface defines contract which can easily be extended for validating requests made by user.
 */
public interface ValidationEngine {

    public void validate(RequestedCourse requestedCourse , List<ValidationException> errors);
}
