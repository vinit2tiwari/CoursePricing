package com.learning.management.system.cart.validations;

import com.learning.management.system.cart.dao.Country;
import com.learning.management.system.cart.dao.Course;
import com.learning.management.system.cart.exceptions.MissingDataException;
import com.learning.management.system.cart.exceptions.ValidationException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.interfaces.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataValidation implements ValidationEngine {

    @Autowired
    private CourseService courseService;

    @Override
    public void validate(RequestedCourse requestedCourse, List<ValidationException> errors) {
        try{
            Course course = courseService.getCourse(requestedCourse.getCourseId());
            Country country = courseService.getCountry(requestedCourse.getLocation());
        } catch (MissingDataException ex){
            errors.add(new ValidationException(ex.getMessage()));
        }
    }
}
