package com.learning.management.system.cart.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Course")
public class Course {

    @Id
    private String id;

    private String name;

    private Double basePrice;

    @ManyToOne(cascade = {CascadeType.PERSIST,
        CascadeType.MERGE})
    @JoinColumn(name = "eligible_subscription_type", referencedColumnName = "id")
    private SubscriptionType subscriptionType;

    @ManyToMany
    @JsonIgnoreProperties("countries")
    Set<Country> countries;

    @OneToOne(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "course")
    private SubscriptionPrice subscriptionPrice;
}
