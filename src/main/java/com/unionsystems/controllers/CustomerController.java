package com.unionsystems.controllers;


import com.unionsystems.dto.ApiResponse;
import com.unionsystems.model.Customer;
import com.unionsystems.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllEmployees() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity getEmployeeById(@PathVariable(value = "id") Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.ok(new ApiResponse("Customer not found"));
        }
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customer")
    public Customer createEmployee(@Valid @RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateEmployee(@PathVariable(value = "id") Long customerId,
                                                   @Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customerId,customer));
    }

    @DeleteMapping("/customer/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long customerId){

        return customerService.deleteCustomer(customerId);
    }
}
