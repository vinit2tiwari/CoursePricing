package com.learning.management.system.cart.validations;

import com.learning.management.system.cart.dao.Course;
import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.exceptions.ValidationException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.interfaces.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class is responsible to  check if particular course is open in requested location
 */
@Component
public class AccessValidations implements ValidationEngine {

    @Autowired
    private CourseService courseService;

    @Override
    public void validate(RequestedCourse requestedCourse, List<ValidationException> errors) {
        try{
            Course course = courseService.getCourse(requestedCourse.getCourseId());
            if(!course.getCountries().stream().anyMatch(country->country.getName().equalsIgnoreCase(requestedCourse.getLocation()))){
                errors.add(new ValidationException("The requested course is not accessible in your location :: " + requestedCourse.toString()));
            }
        }catch (CourseManagementException ex){
            errors.add(new ValidationException(ex.getMessage()));
        }
    }
}
