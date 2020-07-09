package com.learning.management.system.cart.services.impl.pricing;

import com.learning.management.system.cart.dao.Country;
import com.learning.management.system.cart.dao.Taxes;
import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.interfaces.CourseService;
import com.learning.management.system.cart.services.interfaces.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService implements PricingService {

    @Autowired
    private CourseService courseService;

    @Override
    public String getComponentName() {
        return "TAX_SERVICE";
    }

    @Override
    public Double getPrice(RequestedCourse course) throws CourseManagementException {
        //Course  lCourse = courseService.getCourse(course.getCourseId());
        Country country = courseService.getCountry(course.getLocation());
        Double result = 0.0;
        for (Taxes tax : country.getTaxes()) {
            if (tax.isAbsolute()) {
                result += tax.getValue();
            } else {
                result += (tax.getValue() * course.getBasePrice()) / 100;
            }
        }
        return result;
    }
}
