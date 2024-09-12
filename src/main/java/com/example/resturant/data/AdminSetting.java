/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author ASUS
 */
@Entity(name = "admin_setting")
public class AdminSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settingId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "restaurant_about")
    private String restaurantAbout;

    @Column(name = "restaurant_logo")
    private byte[] restaurantLogo;

    @Column(name = "restaurant_cover_photo")
    private byte[] restaurantCoverPhoto;

    @Column(name = "restaurant_email")
    private String restaurantEmail;

    @Column(name = "restaurant_contact_no")
    private String restaurantContactNo;

    @Column(name = "restaurant_address")
    private String restaurantAddress;

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAbout() {
        return restaurantAbout;
    }

    public void setRestaurantAbout(String restaurantAbout) {
        this.restaurantAbout = restaurantAbout;
    }

    public byte[] getRestaurantLogo() {
        return restaurantLogo;
    }

    public void setRestaurantLogo(byte[] restaurantLogo) {
        this.restaurantLogo = restaurantLogo;
    }

    public byte[] getRestaurantCoverPhoto() {
        return restaurantCoverPhoto;
    }

    public void setRestaurantCoverPhoto(byte[] restaurantCoverPhoto) {
        this.restaurantCoverPhoto = restaurantCoverPhoto;
    }

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public void setRestaurantEmail(String restaurantEmail) {
        this.restaurantEmail = restaurantEmail;
    }

    public String getRestaurantContactNo() {
        return restaurantContactNo;
    }

    public void setRestaurantContactNo(String restaurantContactNo) {
        this.restaurantContactNo = restaurantContactNo;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

}
