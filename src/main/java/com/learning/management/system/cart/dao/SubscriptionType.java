package com.learning.management.system.cart.dao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "SubscriptionType")
public class SubscriptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    private String value;

    @OneToMany
    private List<Course> courses;

}
