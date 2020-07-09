package com.learning.management.system.cart.services.impl.pricing;

import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.services.interfaces.PricingService;
import org.springframework.stereotype.Service;

@Service
public class ComponentChargeService implements PricingService {

    @Override
    public String getComponentName() {
        return "COMPONENT_SERVICE";
    }

    @Override
    public Double getPrice(RequestedCourse course) throws CourseManagementException {
        return 0.0;
    }
}
