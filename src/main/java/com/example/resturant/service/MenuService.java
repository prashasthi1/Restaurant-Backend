/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.service;

import com.example.resturant.data.Menu;
import com.example.resturant.data.MenuRepository;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu setMenu(String mealName, BigDecimal mealPrice, MultipartFile file, String mealType) throws IOException {
        Menu menu = new Menu();
        menu.setMealName(mealName);
        menu.setMealPrice(mealPrice);
        menu.setMealType(mealType);
        menu.setMealImage(file.getBytes());
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public List<Menu> getAllMenusByType(String mealType) {
        return menuRepository.findByMealType(mealType);
    }

    public Menu updateMenuById(String mealName, BigDecimal mealPrice, String mealType, MultipartFile file, int id) throws IOException {
        Optional<Menu> existingMenu = menuRepository.findById(id);
        if (existingMenu.isPresent()) {
            Menu menu = existingMenu.get();
            menu.setMealName(mealName);
            menu.setMealPrice(mealPrice);
            menu.setMealType(mealType);
            menu.setMealImage(file.getBytes());
            return menuRepository.save(menu);
        } else {
            return null;
        }
    }

    public void deleteMenuById(int id) {
        menuRepository.deleteById(id);
    }
}