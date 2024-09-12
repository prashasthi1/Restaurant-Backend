/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.service;

import com.example.resturant.data.Customer;
import com.example.resturant.data.CustomerRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Asus
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    PasswordEncoder passwordEncoder;

    public Customer setCustomer(
            String customerName, 
            MultipartFile customerProfile, 
            String contactNo, 
            String email, 
            String password, 
            String customerAddress, 
            String roleType) throws IOException {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            return null;
        } else {
            this.passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);

            Customer customer = new Customer();
            customer.setCustomerName(customerName);
            customer.setCustomerProfile(customerProfile.getBytes());
            customer.setContactNo(contactNo);
            customer.setEmail(email);
            customer.setPassword(encodedPassword);
            customer.setCustomerAddress(customerAddress);
            customer.setRoleType(roleType);
            return customerRepository.save(customer);
        }
    }

    public Customer updateCustomerById(
            String customerName, 
            MultipartFile customerProfile, 
            String contactNo, 
            String email, 
            String password, 
            String customerAddress, 
            String roleType, 
            int customerId) throws IOException {
        Customer customer = new Customer();
        if (customerRepository.findById(customerId).isPresent()) {
            this.passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);

            customer.setCustomerName(customerName);
            customer.setCustomerProfile(customerProfile.getBytes());
            customer.setContactNo(contactNo);
            customer.setEmail(email);
            customer.setPassword(encodedPassword);
            customer.setCustomerAddress(customerAddress);
            customer.setRoleType(roleType);
            customer.setCustomerId(customerId);
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    public List<Customer> viewAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> viewAllCustomersByRoleType(String roleType) {
        return customerRepository.findAllByRoleType(roleType);
    }

    public Optional<Customer> viewAllCustomersById(int customerId) {
        return customerRepository.findById(customerId);
    }

    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public Optional<Customer> customerLogin(
            String email, 
            String password) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {

            Customer customer = optionalCustomer.get();
            this.passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, customer.getPassword())) {
                return Optional.of(customer);
            } else {
                return null;
            }

        } else {
            return null;
        }
    }
}
