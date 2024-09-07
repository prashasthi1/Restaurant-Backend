/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.service;

import com.example.resturant.data.RestaurantTableBook;
import com.example.resturant.data.RestaurantTableBookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class RestaurantTableBookService {

    @Autowired
    RestaurantTableBookRepository restaurantTableBookRepository;

    public RestaurantTableBook setBooking(RestaurantTableBook restaurantTableBook) {
        return restaurantTableBookRepository.save(restaurantTableBook);
    }

    public List<RestaurantTableBook> getAllBookings() {
        return restaurantTableBookRepository.findAll();
    }

    public void deleteBookingById(int id) {
        restaurantTableBookRepository.deleteById(id);
    }

    public RestaurantTableBook updateBookingById(RestaurantTableBook restaurantTableBook, int id) {
        Optional<RestaurantTableBook> existingBooking = restaurantTableBookRepository.findById(id);
        if (existingBooking.isPresent()) {
            restaurantTableBook.setBookId(id);
            return restaurantTableBookRepository.save(restaurantTableBook);
        } else {
            return null;
        }
    }

    public List<RestaurantTableBook> getBookingsByEmail(String email) {
        return restaurantTableBookRepository.findByEmail(email);
    }

    public Optional<RestaurantTableBook> getBookingById(int id) {
        return restaurantTableBookRepository.findById(id);
    }

    public List<RestaurantTableBook> getBookingsByStatus(String status) {
        return restaurantTableBookRepository.findByStatus(status);
    }
}