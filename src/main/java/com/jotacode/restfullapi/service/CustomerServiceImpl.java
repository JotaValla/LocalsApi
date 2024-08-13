package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Customer;
import com.jotacode.restfullapi.data.repository.CustomerRepository;
import com.jotacode.restfullapi.error.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + id));

        if (Objects.nonNull(customer.getFirstName()) && !"".equalsIgnoreCase(customer.getFirstName())) {
            customerToUpdate.setFirstName(customer.getFirstName());
        }
        if (Objects.nonNull(customer.getLastName()) && !"".equalsIgnoreCase(customer.getLastName())) {
            customerToUpdate.setLastName(customer.getLastName());
        }
        if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
            customerToUpdate.setEmail(customer.getEmail());
        }
        //For address for city
        if(Objects.nonNull(customer.getAddress().getCity()) && !"".equalsIgnoreCase(customer.getAddress().getCity())){
            customerToUpdate.getAddress().setCity(customer.getAddress().getCity());
        }
        //main street
        if(Objects.nonNull(customer.getAddress().getMainStreet()) && !"".equalsIgnoreCase(customer.getAddress().getMainStreet())){
            customerToUpdate.getAddress().setMainStreet(customer.getAddress().getMainStreet());
        }
        //second street
        if(Objects.nonNull(customer.getAddress().getSecondStreet()) && !"".equalsIgnoreCase(customer.getAddress().getSecondStreet())){
            customerToUpdate.getAddress().setSecondStreet(customer.getAddress().getSecondStreet());
        }



        return customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public Optional<Customer> findCustomerByLastNameEqualsIgnoreCase(String name) throws CustomerNotFoundException {
        return customerRepository.findByLastNameEqualsIgnoreCase(name);
    }

    @Override
    public List<Customer> findAllCustomersByFirstNameContaining(String name) {
        return customerRepository.findAllByFirstNameContaining(name);
    }

    @Override
    public List<Customer> findAllCustomersByCity(String city) {
        return customerRepository.findAllByAddress_City(city);
    }
}
