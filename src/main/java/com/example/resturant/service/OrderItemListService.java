/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.service;

import com.example.resturant.data.OrderItemList;
import com.example.resturant.data.OrderItemListRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OrderItemListService {

    @Autowired
    OrderItemListRepository orderItemListRepositiry;

    public OrderItemList setOrderItem(OrderItemList orderItemList) {
        return orderItemListRepositiry.save(orderItemList);
    }

    public OrderItemList updateOrderItemByOrderItemId(OrderItemList orderItemList, int orderItemId) {
        if (orderItemListRepositiry.findById(orderItemId).isPresent()) {
            orderItemList.setMealId(orderItemList.getMealId());
            orderItemList.setOrderId(orderItemList.getOrderId());
            orderItemList.setPrice(orderItemList.getPrice());
            orderItemList.setQuantity(orderItemList.getQuantity());
            orderItemList.setOrderItemId(orderItemId);
            return orderItemListRepositiry.save(orderItemList);
        } else{
            return null;
        }
    }
    
    public List<OrderItemList> viewAllOrderItem(){
      return orderItemListRepositiry.findAll();
    }
    
    public List<OrderItemList> viewAllOrderItemByOrderId(int orderId){
      return orderItemListRepositiry.findAllByOrderId(orderId);
    }
    
    public Optional<OrderItemList> viewAllOrderItemByOrderItemid(int orderItemId){
      return orderItemListRepositiry.findById(orderItemId);
    }
    
    public void deleteOrderItems() {
        orderItemListRepositiry.deleteAll();
    }

    @Transactional
    public void deleteOrderItemsByOrderId(int orderId) {
        orderItemListRepositiry.deleteAllByOrderId(orderId);
    }

    public void deleteOrderItemByOrderItemid(int orderItemId) {
        orderItemListRepositiry.deleteById(orderItemId);
    }
}
