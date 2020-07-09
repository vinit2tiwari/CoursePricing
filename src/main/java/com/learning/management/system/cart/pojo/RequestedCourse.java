package com.learning.management.system.cart.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestedCourse {

    private String courseId;

    private String location;

    private Double basePrice;

    private String currency;

    @Override
    public String toString(){
        return new String("course_id :: " + courseId + "\n location :: " + location + "\n currency ::  " + currency);
    }
}
