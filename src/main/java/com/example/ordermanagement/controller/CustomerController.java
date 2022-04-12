package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Customer;
import com.example.ordermanagement.repository.CustomerRepository;
import com.example.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

  @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomer();
  }
  @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
  }
}
