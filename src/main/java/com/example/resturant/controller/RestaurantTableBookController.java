/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.controller;

import com.example.resturant.data.RestaurantTableBook;
import com.example.resturant.service.RestaurantTableBookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/restauranttablebook")
public class RestaurantTableBookController {

    @Autowired
    RestaurantTableBookService restaurantTableBookService;

    @PostMapping("/add-tablebooking")
    public RestaurantTableBook setBooking(
            @RequestBody RestaurantTableBook restaurantTableBook) {
        return restaurantTableBookService.setBooking(restaurantTableBook);
    }

    @GetMapping("/view-all-tablebookings")
    public List<RestaurantTableBook> getAllBookings() {
        return restaurantTableBookService.getAllBookings();
    }

    @DeleteMapping("/delete-tablebooking/{id}")
    public void deleteBookingById(@PathVariable("id") int id) {
        restaurantTableBookService.deleteBookingById(id);
    }

    @PutMapping("/update-tablebooking/{id}")
    public RestaurantTableBook updateBookingById(
            @RequestBody RestaurantTableBook restaurantTableBook, 
            @PathVariable("id") int id) {
        return restaurantTableBookService.updateBookingById(restaurantTableBook, id);
    }

    @GetMapping("/view-tablebooking-by-email")
    public List<RestaurantTableBook> getBookingsByEmail(
            @RequestParam("email") String email) {
        return restaurantTableBookService.getBookingsByEmail(email);
    }

    @GetMapping("/view-tablebooking-by-id")
    public Optional<RestaurantTableBook> getBookingById(
            @RequestParam("id") int id) {
        return restaurantTableBookService.getBookingById(id);
    }

    @GetMapping("/view-tablebooking-by-status")
    public List<RestaurantTableBook> getBookingsByStatus(
            @RequestParam("status") String status) {
        return restaurantTableBookService.getBookingsByStatus(status);
    }
}