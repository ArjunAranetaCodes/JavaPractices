package com.customer.service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    public List<Customer> searchCustomers(String query) {
        return customerRepository.searchCustomers(query);
    }

    public List<Customer> getCustomersByStatus(Customer.Status status) {
        return customerRepository.findByStatus(status);
    }

    public List<Customer> getCustomersByIndustry(Customer.Industry industry) {
        return customerRepository.findByIndustry(industry);
    }

    public Customer createCustomer(Customer customer) {
        if (customer.getStatus() == null) {
            customer.setStatus(Customer.Status.LEAD);
        }
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(customerDetails.getFirstName());
            customer.setLastName(customerDetails.getLastName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhone(customerDetails.getPhone());
            customer.setCompany(customerDetails.getCompany());
            customer.setIndustry(customerDetails.getIndustry());
            customer.setStatus(customerDetails.getStatus() != null ? customerDetails.getStatus() : Customer.Status.LEAD);
            customer.setAddress(customerDetails.getAddress());
            customer.setCity(customerDetails.getCity());
            customer.setState(customerDetails.getState());
            customer.setZipCode(customerDetails.getZipCode());
            customer.setCountry(customerDetails.getCountry());
            customer.setNotes(customerDetails.getNotes());
            return customerRepository.save(customer);
        }
        return null;
    }

    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
