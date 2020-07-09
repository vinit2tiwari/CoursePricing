package com.learning.management.system.cart.services.interfaces;

import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;

/**
 * This interface defines contract using which pricing strategy can be provided.
 */
public interface PricingService {

    String getComponentName();

    Double getPrice(RequestedCourse course) throws CourseManagementException;

}
