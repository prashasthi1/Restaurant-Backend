/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.service;

import com.example.resturant.data.Order;
import com.example.resturant.data.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OrderService {

    @Autowired
    OrderRepository OrderRepository;

    public Order setOrder(Order order) {
        return OrderRepository.save(order);
    }

    public Order upadteOrderById(Order order, int orderId) {
        if (OrderRepository.findById(orderId).isPresent()) {
            order.setCustomerId(order.getCustomerId());
            order.setDeliveryAddress(order.getDeliveryAddress());
            order.setOrderDate(order.getOrderDate());
            order.setPaymentMethod(order.getPaymentMethod());
            order.setTotalAmout(order.getTotalAmout());
            order.setOrderStatus(order.getOrderStatus());
            order.setOrderId(orderId);
            return OrderRepository.save(order);
        } else {
            return null;
        }
    }
    
    public List<Order> viewAllOrders(){
        return OrderRepository.findAll();
    }
    
    public List<Order> viewAllOrdersByCustomerId(int customerId){
        return OrderRepository.findAllByCustomerId(customerId);
    }
    
    public List<Order> viewAllOrdersByStatus(String orderStatus){
        return OrderRepository.findAllByOrderStatus(orderStatus);
    }
    
    public void deleteOrderById(int orderId){
       OrderRepository.deleteById(orderId);
    }
}


