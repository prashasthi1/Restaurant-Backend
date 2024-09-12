/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.resturant.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface RestaurantTableBookRepository extends JpaRepository<RestaurantTableBook, Integer> {

    // Custom method to find bookings by email
    List<RestaurantTableBook> findByEmail(String email);

    // Custom method to find bookings by status
    List<RestaurantTableBook> findByStatus(String status);



}