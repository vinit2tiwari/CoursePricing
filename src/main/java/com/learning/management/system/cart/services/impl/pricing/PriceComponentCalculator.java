package com.learning.management.system.cart.services.impl.pricing;

import com.learning.management.system.cart.dao.Course;
import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.impl.integrations.CurrencyConverterService;
import com.learning.management.system.cart.services.interfaces.CourseService;
import com.learning.management.system.cart.services.interfaces.PricingService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceComponentCalculator {

    @Autowired
    private List<PricingService> availaiblePricingServices;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CurrencyConverterService currencyConverterService;

    public Map<String , Double> calculatePrice(RequestedCourse requestedCourse) throws CourseManagementException {
        Map<String ,  Double> priceMap = new HashMap<>();

        //If base price is not provided explicitly, get it from  database
        if(requestedCourse.getBasePrice() == null){
            Course course = courseService.getCourse(requestedCourse.getCourseId());
            requestedCourse.setBasePrice(course.getBasePrice());
        }

        for(PricingService pricingService : availaiblePricingServices){
            priceMap.put(pricingService.getComponentName(),pricingService.getPrice(requestedCourse));
        }


        for(Entry<String,Double> entry : priceMap.entrySet()){
            double newVal = entry.getValue()*currencyConverterService.getCurrencyRate(requestedCourse.getCurrency() , "INR");
            priceMap.put(entry.getKey(), newVal);
        }

        return priceMap;
    }

}
