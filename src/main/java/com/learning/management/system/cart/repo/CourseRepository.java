package com.learning.management.system.cart.repo;

import com.learning.management.system.cart.dao.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course , String> {

    Course findCourseById(String id);
}
