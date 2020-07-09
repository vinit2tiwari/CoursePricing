package com.learning.management.system.cart.services.interfaces;

import com.learning.management.system.cart.dao.Country;
import com.learning.management.system.cart.dao.Course;
import com.learning.management.system.cart.exceptions.MissingDataException;
import com.learning.management.system.cart.pojo.RequestedCourse;

public interface CourseService {

    public String getCourseStrategy(RequestedCourse requestedCourse) throws MissingDataException;

    public Course getCourse(String course_id) throws MissingDataException;

    public Country getCountry(String name) throws MissingDataException;

}
