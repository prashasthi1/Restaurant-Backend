/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.service;


import com.example.resturant.data.AdminSetting;
import com.example.resturant.data.AdminSettingRepository;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Service
public class AdminSettingService {

    @Autowired
    AdminSettingRepository adminSettingRepository;

    public AdminSetting setSetting(String restaurantName, String restaurantAbout, MultipartFile restaurantLogo, MultipartFile restaurantCoverPhoto, String restaurantEmail, String restaurantContactNo, String restaurantAddress) throws IOException {
        AdminSetting adminsetting = new AdminSetting();
        adminsetting.setRestaurantName(restaurantName);
        adminsetting.setRestaurantAbout(restaurantAbout);
        adminsetting.setRestaurantLogo(restaurantLogo.getBytes());
        adminsetting.setRestaurantCoverPhoto(restaurantCoverPhoto.getBytes());
        adminsetting.setRestaurantEmail(restaurantEmail);
        adminsetting.setRestaurantContactNo(restaurantContactNo);
        adminsetting.setRestaurantAddress(restaurantAddress);
        return adminSettingRepository.save(adminsetting);
    }

    public Optional<AdminSetting> getSettingById(int id) {
        return adminSettingRepository.findById(id);
    }

    public AdminSetting updateSetting(String restaurantName, String restaurantAbout, MultipartFile restaurantLogo, MultipartFile restaurantCoverPhoto, String restaurantEmail, String restaurantContactNo, String restaurantAddress, int id) throws IOException {
        Optional<AdminSetting> existingSetting = adminSettingRepository.findById(id);
        if (existingSetting.isPresent()) {
            AdminSetting adminsetting = existingSetting.get();
            adminsetting.setRestaurantName(restaurantName);
            adminsetting.setRestaurantAbout(restaurantAbout);
            adminsetting.setRestaurantLogo(restaurantLogo.getBytes());
            adminsetting.setRestaurantCoverPhoto(restaurantCoverPhoto.getBytes());
            adminsetting.setRestaurantEmail(restaurantEmail);
            adminsetting.setRestaurantContactNo(restaurantContactNo);
            adminsetting.setRestaurantAddress(restaurantAddress);
            return adminSettingRepository.save(adminsetting);  // Corrected this line
        } else {
            return null;
        }
    }

    public void deleteSettingById(int id) {
        adminSettingRepository.deleteById(id);
    }
}
