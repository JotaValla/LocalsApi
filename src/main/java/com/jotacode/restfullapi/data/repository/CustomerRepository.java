package com.jotacode.restfullapi.data.repository;

import com.jotacode.restfullapi.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Find a customer by last name
    Optional<Customer> findByLastNameEqualsIgnoreCase(String lastName);

}
