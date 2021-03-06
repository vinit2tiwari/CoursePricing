package com.learning.management.system.cart.services.impl.strategy;

import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.impl.pricing.PriceComponentCalculator;
import com.learning.management.system.cart.services.interfaces.CourseStrategy;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ONE_TIME")
public class OneTimePaymentStrategy implements CourseStrategy {

    @Autowired
    private PriceComponentCalculator priceComponentCalculator;

    @Override
    public Map<String, Double> getCoursePrice(RequestedCourse requestedCourse) throws CourseManagementException{
        return priceComponentCalculator.calculatePrice(requestedCourse);
    }
}
