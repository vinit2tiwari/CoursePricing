package com.learning.management.system.cart.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int country_id;

    private String name;

    @ManyToMany(cascade = { CascadeType.PERSIST,
        CascadeType.MERGE })
    @JoinTable(
        name = "Country_Tax_Mapping",
        joinColumns = { @JoinColumn(name = "country_id") },
        inverseJoinColumns = { @JoinColumn(name = "tax_id") }
    )
    @JsonIgnoreProperties("taxes")
    Set<Taxes> taxes = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.PERSIST,
        CascadeType.MERGE } , fetch = FetchType.LAZY)
    @JoinTable(
        name = "Course_Country_Mapping",
        joinColumns = { @JoinColumn(name = "country_id") },
        inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    @JsonIgnoreProperties("courses")
    Set<Course> courses = new HashSet<>();
}
