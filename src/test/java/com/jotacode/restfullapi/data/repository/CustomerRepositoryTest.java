package com.jotacode.restfullapi.data.repository;

import com.jotacode.restfullapi.data.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        // Given
        Customer customer = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@example.com")
                .build();
        customerRepository.save(customer);
    }
}