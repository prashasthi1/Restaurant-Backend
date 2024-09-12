/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.controller;

import com.example.resturant.data.OrderItemList;
import com.example.resturant.service.OrderItemListService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class OrderItemListController {

    @Autowired
    OrderItemListService orderItemListController;

    @CrossOrigin
    @PostMapping(path = "/set-order-item")
    public OrderItemList setOrderItem(@RequestBody OrderItemList orderItemList) {
        return orderItemListController.setOrderItem(orderItemList);
    }

    @CrossOrigin
    @PutMapping(path = "/update-order-item/{orderItemId}")
    public OrderItemList updateOrderItemByOrderItemId(
            @RequestBody OrderItemList orderItemList, 
            @PathVariable("orderItemId") int orderItemId) {
        return orderItemListController.updateOrderItemByOrderItemId(orderItemList, orderItemId);
    }

    @CrossOrigin
    @GetMapping(path = "/view-all-order-items")
    public List<OrderItemList> viewAllOrderItem() {
        return orderItemListController.viewAllOrderItem();
    }

    @CrossOrigin
    @GetMapping(path = "/view-all-order-items/{orderId}")
    public List<OrderItemList> viewAllOrderItemByOrderId(
            @PathVariable("orderId") int orderId) {
        return orderItemListController.viewAllOrderItemByOrderId(orderId);
    }

    @CrossOrigin
    @GetMapping(path = "/view-order-item/{orderItemId}")
    public Optional<OrderItemList> viewOrderItemByOrderItemid(
            @PathVariable("orderItemId") int orderItemId) {
        return orderItemListController.viewAllOrderItemByOrderItemid(orderItemId);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete-all-order-items")
    public void deleteOrderItems() {
        orderItemListController.deleteOrderItems();
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete-all-order-items/{orderId}")
    public void deleteOrderItemsByOrderId(
            @PathVariable("orderId") int orderId) {
        orderItemListController.deleteOrderItemsByOrderId(orderId);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete-order-items/{orderItemId}")
    public void deleteOrderItemByOrderItemid(
            @PathVariable("orderItemId") int orderItemId) {
        orderItemListController.deleteOrderItemByOrderItemid(orderItemId);
    }
}
