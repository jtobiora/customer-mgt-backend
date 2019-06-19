package com.unionsystems.services;

import com.unionsystems.model.Customer;
import com.unionsystems.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId){
        Customer employee = customerRepository.findOne(customerId);
        return employee;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId,Customer customerDetails){
        Customer customer = customerRepository.findOne(customerId);
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getAddress());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setLastName(customerDetails.getLastName());
        customer.setFirstName(customerDetails.getFirstName());
        final Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }

    public Map<String, Boolean> deleteCustomer(Long customerId){
        Customer customer = customerRepository.findOne(customerId);

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
