package com.jotacode.restfullapi.controller;

import com.jotacode.restfullapi.data.entity.Customer;
import com.jotacode.restfullapi.error.CustomerNotFoundException;
import com.jotacode.restfullapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //Operaciones CRUD
    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping("/createCustomer")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable Long id,@RequestBody Customer customer) throws CustomerNotFoundException{
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.findById(id);
    }

    //Another operations
    @GetMapping("/customerByLastName/{lastName}")
    public Customer findCustomerByLastNameEqualsIgnoreCase(@PathVariable String lastName) throws CustomerNotFoundException {
        return customerService.findCustomerByLastNameEqualsIgnoreCase(lastName).get();
    }

    //get all customers by first name containing a string
    @GetMapping("/customersContains/{name}")
    public List<Customer> findAllCustomersByFirstNameContaining(@PathVariable String name) {
        return customerService.findAllCustomersByFirstNameContaining(name);
    }

    //get all customers by the city name
    @GetMapping("/customersByCity/{city}")
    public List<Customer> findAllCustomersByCity(@PathVariable String city) {
        return customerService.findAllCustomersByCity(city);
    }

}
