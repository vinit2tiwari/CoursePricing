package com.learning.management.system.cart.services.interfaces;

import com.learning.management.system.cart.exceptions.CourseManagementException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import java.util.Map;

public interface CourseStrategy {

    Map<String, Double> getCoursePrice(RequestedCourse requestedCourse) throws CourseManagementException;

}
