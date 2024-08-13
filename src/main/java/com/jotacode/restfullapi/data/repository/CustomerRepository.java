package com.jotacode.restfullapi.data.repository;

import com.jotacode.restfullapi.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Find a customer by last name
    Optional<Customer> findByLastNameEqualsIgnoreCase(String lastName);

    //Find all customers by first name containing a string
    List<Customer> findAllByFirstNameContaining(String name);

    //
    List<Customer> findAllByAddress_City(String city);


}
