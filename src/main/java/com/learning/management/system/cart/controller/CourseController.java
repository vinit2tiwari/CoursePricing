package com.learning.management.system.cart.controller;

import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.exceptions.ValidationException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.impl.strategy.PricingStrategyLoader;
import com.learning.management.system.cart.services.interfaces.CourseStrategy;
import com.learning.management.system.cart.validations.ValidationEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @Autowired
    private List<ValidationEngine> validationEngines;

    @Autowired
    private PricingStrategyLoader pricingStrategyLoader;

    @GetMapping(path = "/price")
    public ResponseEntity<Object> getCoursePrice(String courseId, String countryCode ,  String currency) {

        RequestedCourse requestedCourse =new RequestedCourse();
        requestedCourse.setCourseId(courseId);
        requestedCourse.setLocation(countryCode == null ? "INDIA" : countryCode);
        requestedCourse.setCurrency(currency);

        List<ValidationException> errors = new ArrayList<>();
        validationEngines.stream().forEach(validationEngine -> validationEngine.validate(requestedCourse,errors));

        if(!errors.isEmpty()){
            return new ResponseEntity<>(errors.stream().map(exception->exception.getMessage()).collect(Collectors.toList()) , HttpStatus.NOT_ACCEPTABLE);
        }

        Map<String, Double> result = new HashMap<>();
        try{
            CourseStrategy courseStrategy = pricingStrategyLoader.getCourseStrategy(requestedCourse);
             result = courseStrategy.getCoursePrice(requestedCourse);;
        }catch (CourseManagementException ex){
            errors.add(new ValidationException(ex.getMessage()));
            return new ResponseEntity<>(errors.stream().map(exception->exception.getMessage()).collect(Collectors.toList()) , HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(result , HttpStatus.ACCEPTED);
    }
}
