package com.learning.management.system.cart.services.impl.pricing;

import com.learning.management.system.cart.dao.Course;
import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.interfaces.CourseService;
import com.learning.management.system.cart.services.interfaces.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasePriceService implements PricingService {

    @Autowired
    private CourseService  courseService;

    @Override
    public String getComponentName() {
        return "BASE_PRICE";
    }

    @Override
    public Double getPrice(RequestedCourse course) throws CourseManagementException {
        Double basePrice = course.getBasePrice();
        if(basePrice == null){
            Course lCourse = courseService.getCourse(course.getCourseId());
            return lCourse.getBasePrice();
        }

        return basePrice;
    }
}
