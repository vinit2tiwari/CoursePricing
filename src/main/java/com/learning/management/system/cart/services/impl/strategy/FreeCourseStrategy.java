package com.learning.management.system.cart.services.impl.strategy;

import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.impl.pricing.BasePriceService;
import com.learning.management.system.cart.services.interfaces.CourseStrategy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FREE")
public class FreeCourseStrategy implements CourseStrategy {

    @Autowired
    private BasePriceService basePriceService;

    @Override
    public Map<String, Double> getCoursePrice(RequestedCourse requestedCourse) {
        Map<String,Double> map = new HashMap<>();
        //Return base price as 0 for free courses.
        map.put(basePriceService.getComponentName() , 0.0);
        return map;
    }
}
