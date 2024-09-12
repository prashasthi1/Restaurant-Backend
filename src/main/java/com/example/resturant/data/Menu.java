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
import jakarta.persistence.Lob;
import java.math.BigDecimal;

/**
 *
 * @author ASUS
 */

@Entity(name="customer_menu")
public class Menu {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "meal_id")
   private int mealId; 
   
   @Column(name="meal_name")
   private String mealName;
   
   @Column(name="meal_price")
   private BigDecimal mealPrice;
   
   @Lob
   @Column(name="meal_image")
   private byte[] mealImage;
   
   @Column(name="meal_type")
   private String mealType;

    // Getters and Setters
    
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public BigDecimal getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(BigDecimal mealPrice) {
        this.mealPrice = mealPrice;
    }

    
    public byte[] getMealImage() {
        return mealImage;
    }

    public void setMealImage(byte[] mealImage) {
        this.mealImage = mealImage;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }


    
}
