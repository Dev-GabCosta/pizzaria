package com.zup.pizzaria.repository;

import com.zup.pizzaria.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
