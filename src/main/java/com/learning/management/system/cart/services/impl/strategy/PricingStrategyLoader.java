package com.learning.management.system.cart.services.impl.strategy;

import com.learning.management.system.cart.exceptions.MissingDataException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.interfaces.CourseService;
import com.learning.management.system.cart.services.interfaces.CourseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PricingStrategyLoader {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CourseService courseService;

    public CourseStrategy getCourseStrategy(RequestedCourse requestedCourse) throws MissingDataException {
        return applicationContext.getBean(courseService.getCourseStrategy(requestedCourse), CourseStrategy.class);
    }

}
