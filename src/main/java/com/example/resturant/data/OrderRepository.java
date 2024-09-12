/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.resturant.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ASUS
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findAllByCustomerId(int customerId);

    public List<Order> findAllByOrderStatus(String orderStatus);
    
}
