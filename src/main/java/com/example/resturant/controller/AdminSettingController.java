/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.example.resturant.controller;

import com.example.resturant.data.AdminSetting;
import com.example.resturant.service.AdminSettingService;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/setting")
public class AdminSettingController {

    @Autowired
    AdminSettingService adminSettingService;

    @CrossOrigin
    @PostMapping(path = "/set-setting")
    public AdminSetting setSetting(@RequestParam("restaurantName") String restaurantName,
                                   @RequestParam("restaurantAbout") String restaurantAbout,
                                   @RequestParam("restaurantLogo") MultipartFile restaurantLogo,
                                   @RequestParam("restaurantCoverPhoto") MultipartFile restaurantCoverPhoto,
                                   @RequestParam("restaurantEmail") String restaurantEmail,
                                   @RequestParam("restaurantContactNo") String restaurantContactNo,
                                   @RequestParam("restaurantAddress") String restaurantAddress) throws IOException {
        return adminSettingService.setSetting(restaurantName, restaurantAbout, restaurantLogo, restaurantCoverPhoto, restaurantEmail, restaurantContactNo, restaurantAddress);
    }

    @CrossOrigin
    @GetMapping(path = "/get-setting-by-id/{id}")
    public Optional<AdminSetting> getSettingById(@PathVariable("id") int id) {
        return adminSettingService.getSettingById(id);
    }

    @CrossOrigin
    @PutMapping(path = "/update-setting/{id}")
    public AdminSetting updateSetting(@RequestParam("restaurantName") String restaurantName,
                                      @RequestParam("restaurantAbout") String restaurantAbout,
                                      @RequestParam("restaurantLogo") MultipartFile restaurantLogo,
                                      @RequestParam("restaurantCoverPhoto") MultipartFile restaurantCoverPhoto,
                                      @RequestParam("restaurantEmail") String restaurantEmail,
                                      @RequestParam("restaurantContactNo") String restaurantContactNo,
                                      @RequestParam("restaurantAddress") String restaurantAddress,
                                      @PathVariable("id") int id) throws IOException {
        return adminSettingService.updateSetting(restaurantName, restaurantAbout, restaurantLogo, restaurantCoverPhoto, restaurantEmail, restaurantContactNo, restaurantAddress, id);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete-setting/{id}")
    public void deleteSettingById(@PathVariable("id") int id) {
        adminSettingService.deleteSettingById(id);
    }
}
