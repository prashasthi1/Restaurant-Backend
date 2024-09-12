/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.controller;

import com.example.resturant.data.Customer;
import com.example.resturant.service.CustomerService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @CrossOrigin
    @PostMapping(path = "/create-customers")
    public Customer setCustomer(
            @RequestParam("customerName") String customerName, 
            @RequestParam("customerProfile") MultipartFile customerProfile, 
            @RequestParam("contactNo") String contactNo, 
            @RequestParam("email") String email, 
            @RequestParam("password") String password, 
            @RequestParam("customerAddress") String customerAddress, 
            @RequestParam("roleType") String roleType) throws IOException {
        return customerService.setCustomer(customerName, customerProfile, contactNo, email, password, customerAddress, roleType);
    }
    
    @CrossOrigin
    @PutMapping(path = "/update-customer/{customerId}")
    public Customer updateCustomerById(
            @RequestParam("customerName") String customerName, 
            @RequestParam("customerProfile") MultipartFile customerProfile, 
            @RequestParam("contactNo") String contactNo, 
            @RequestParam("email") String email, 
            @RequestParam("password") String password, 
            @RequestParam("customerAddress") String customerAddress, 
            @RequestParam("roleType") String roleType, 
            @PathVariable("customerId") int customerId) throws IOException {
        return customerService.updateCustomerById(customerName, customerProfile, contactNo, email, password, customerAddress, roleType, customerId);
    }

    @CrossOrigin
    @GetMapping(path = "/view-all-customers")
    public List<Customer> viewAllCustomers() {
        return customerService.viewAllCustomers();
    }
    
    @CrossOrigin
    @GetMapping(path = "/view-all-customers-by-role")
    public List<Customer> viewAllCustomersByRoleType(@RequestParam("roleType") String roleType) {
        return customerService.viewAllCustomersByRoleType(roleType);
    }
    
    @CrossOrigin
    @GetMapping(path = "/view-all-customers/{customerId}")
    public Optional<Customer> viewAllCustomersById(@PathVariable("customerId") int customerId) {
        return customerService.viewAllCustomersById(customerId);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete-customer/{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomerById(customerId);
    }
    
    @CrossOrigin
    @GetMapping(path = "/customer-login")
    public Optional<Customer> customerLogin(@RequestParam("email") String email,@RequestParam("password") String password){
       return customerService.customerLogin(email,password);
    }
}
