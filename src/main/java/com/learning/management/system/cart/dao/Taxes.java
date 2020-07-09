package com.learning.management.system.cart.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Taxes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int taxId;

    private boolean isAbsolute;

    private String description;

    private Double value;

    @ManyToMany
    @JsonIgnoreProperties("countries")
    private Set<Country> countries = new HashSet<>();
}
