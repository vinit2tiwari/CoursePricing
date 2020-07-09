package com.learning.management.system.cart.repo;

import com.learning.management.system.cart.dao.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    public Country findCountryByName(String name);
}
