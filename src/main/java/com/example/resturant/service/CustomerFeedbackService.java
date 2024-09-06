/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.service;

import com.example.resturant.data.CustomerFeedback;
import com.example.resturant.data.CustomerFeedbackRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CustomerFeedbackService {

    @Autowired
    CustomerFeedbackRepository customerFeedbackRepository;

    // Save or update feedback
    public CustomerFeedback setFeedback(CustomerFeedback customerFeedback) {
        return customerFeedbackRepository.save(customerFeedback);
    }

    // Get all feedback entries
    public List<CustomerFeedback> getAllFeedback() {
        return customerFeedbackRepository.findAll();
    }

}