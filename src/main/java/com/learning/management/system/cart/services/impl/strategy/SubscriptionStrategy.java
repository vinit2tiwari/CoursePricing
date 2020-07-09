package com.learning.management.system.cart.services.impl.strategy;

import com.learning.management.system.cart.dao.Course;
import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.impl.pricing.PriceComponentCalculator;
import com.learning.management.system.cart.services.interfaces.CourseService;
import com.learning.management.system.cart.services.interfaces.CourseStrategy;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SUBSCRIPTION")
public class SubscriptionStrategy implements CourseStrategy {

    @Autowired
    private CourseService courseService;

    @Autowired
    private PriceComponentCalculator priceComponentCalculator;

    @Override
    public Map<String, Double> getCoursePrice(RequestedCourse requestedCourse) throws CourseManagementException {
        Course course = courseService.getCourse(requestedCourse.getCourseId());
        requestedCourse.setBasePrice(course.getSubscriptionPrice().getSubscription_rate());
        return priceComponentCalculator.calculatePrice(requestedCourse);
    }
}
