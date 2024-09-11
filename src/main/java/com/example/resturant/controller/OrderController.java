/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.controller;

import com.example.resturant.data.Order;
import com.example.resturant.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @CrossOrigin
    @PostMapping(path= "/set-food-order")
    public Order setOrder(@RequestBody Order order){
        return orderService.setOrder(order);
    }
    
    @CrossOrigin
    @PutMapping(path= "/update-food-order/{orderId}")
    public Order upadteOrderById(@RequestBody Order order,@PathVariable("orderId") int orderId){
        return orderService.upadteOrderById(order,orderId);
    }
    
    
    @CrossOrigin
    @GetMapping(path = "/view-all-food-orders")
    public List<Order> viewAllOrders(){
        return orderService.viewAllOrders();
    }
    
    @CrossOrigin
    @GetMapping(path = "/view-all-food-orders/{customerId}")
    public List<Order> viewAllOrdersByCustomerId(@PathVariable("customerId") int customerId){
        return orderService.viewAllOrdersByCustomerId(customerId);
    }
    
    @CrossOrigin
    @GetMapping(path = "/view-all-food-orders-by-status")
    public List<Order> viewAllOrdersByStatus(@RequestParam("orderStatus") String orderStatus){
        return orderService.viewAllOrdersByStatus(orderStatus);
    }
    
    @CrossOrigin
    @DeleteMapping(path = "/delete/food-order/{orderId}")
    public void deleteOrderById(@PathVariable("orderId") int orderId){
       orderService.deleteOrderById(orderId); 
    }
    
}

