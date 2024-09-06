/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.controller;

import com.example.resturant.data.CustomerFeedback;
import com.example.resturant.service.CustomerFeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/feedback")
public class CustomerFeedbackController {

    @Autowired
    CustomerFeedbackService customerFeedbackService;

   
    @PostMapping("/set-customer-feedback")
    public CustomerFeedback setFeedback(
            @RequestBody CustomerFeedback customerFeedback) {
        return customerFeedbackService.setFeedback(customerFeedback);
    }

   
    @GetMapping("/view-all-customer-feedback")
    public List<CustomerFeedback> getAllFeedback() {
        return customerFeedbackService.getAllFeedback();
    }
}