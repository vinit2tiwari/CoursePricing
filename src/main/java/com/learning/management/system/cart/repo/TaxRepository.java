package com.learning.management.system.cart.repo;

import com.learning.management.system.cart.dao.Taxes;
import org.springframework.data.repository.CrudRepository;

public interface TaxRepository extends CrudRepository<Taxes , Integer> {
    public Taxes findByTaxId(int taxId);
}
