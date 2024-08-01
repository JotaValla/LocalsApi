package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Customer;

import com.jotacode.restfullapi.error.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer) throws CustomerNotFoundException;

    void deleteCustomer(Long id);

    Customer findById(Long id) throws CustomerNotFoundException;

    Optional<Customer> findCustomerByLastNameEqualsIgnoreCase(String name) throws CustomerNotFoundException;



}
