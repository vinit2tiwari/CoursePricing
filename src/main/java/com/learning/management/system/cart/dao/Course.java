package com.learning.management.system.cart.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "course")
@JsonIgnoreProperties("countries")
public class Course {

    @Id
    private String id;

    private String name;

    private Double basePrice;

    @ManyToOne(cascade = {CascadeType.PERSIST,
        CascadeType.MERGE})
    @JoinColumn(name = "eligible_subscription_type", referencedColumnName = "id")
    private SubscriptionType subscriptionType;

    @ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinTable(name ="course_country_mapping" ,
            joinColumns = {@JoinColumn(name = "course_id")},
             inverseJoinColumns = {@JoinColumn(name = "country_id")}  )
        @ToString.Exclude
    Set<Country> countries = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "course")
    private SubscriptionPrice subscriptionPrice;
}
