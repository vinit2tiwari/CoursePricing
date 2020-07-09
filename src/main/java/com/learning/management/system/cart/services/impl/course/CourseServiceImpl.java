package com.learning.management.system.cart.services.impl.course;

import com.learning.management.system.cart.dao.Country;
import com.learning.management.system.cart.dao.Course;
import com.learning.management.system.cart.exceptions.MissingDataException;
import com.learning.management.system.cart.pojo.RequestedCourse;
import com.learning.management.system.cart.repo.CountryRepository;
import com.learning.management.system.cart.repo.CourseRepository;
import com.learning.management.system.cart.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("singelton")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public String getCourseStrategy(RequestedCourse requestedCourse) throws MissingDataException {
        Course course = courseRepository.findCourseById(requestedCourse.getCourseId());
        String strategy =  course.getSubscriptionType().getValue();

        if(strategy == null || strategy.isEmpty()){
            throw new MissingDataException("Invalid course requested ::  "  + requestedCourse.toString());
        }
        return strategy;
    }

    @Override
    public Course getCourse(String course_id) throws MissingDataException {
        Course course =  courseRepository.findCourseById(course_id);
        if(course ==  null){
            throw new MissingDataException("No Course data could be  found for requested course :: " + course_id);
        }

        return course;
    }

    @Override
    public Country getCountry(String name) throws MissingDataException {
        Country country =  countryRepository.findCountryByName(name);

        if(country  == null){
            throw new MissingDataException("No record found for requested country :: "  + name);
        }

        return country;
    }
}
