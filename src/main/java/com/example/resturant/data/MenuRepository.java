/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public interface MenuRepository extends JpaRepository<Menu, Integer>{

    public List<Menu> findAllByMealType(String mealType);

    public List<Menu> findByMealType(String mealType);
  
    
}