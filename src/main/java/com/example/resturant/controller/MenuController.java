/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resturant.controller;

import com.example.resturant.data.Menu;
import com.example.resturant.service.MenuService; // Added this import for MenuService
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
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
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    MenuService menuService; 

    @CrossOrigin
    @PostMapping(path = "/add-menu")
    public Menu setMenu(@RequestParam("mealName") String mealName,
                        @RequestParam("mealPrice") BigDecimal mealPrice,
                        @RequestParam("mealType") String mealType,
                        @RequestParam("mealImage") MultipartFile file) throws IOException {
        return menuService.setMenu(mealName, mealPrice, file, mealType);
    }

    @CrossOrigin
    @GetMapping(path = "/view-all-menu")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @CrossOrigin
    @GetMapping(path = "/view-all-menu-by-type")
    public List<Menu> getAllMenusByType(
            @RequestParam("mealType") String mealType) {
        return menuService.getAllMenusByType(mealType);
    }

    @CrossOrigin
    @PutMapping(path = "/update-menu/{id}")
    public Menu updateMenuById(@RequestParam("mealName") String mealName,
                               @RequestParam("mealPrice") BigDecimal mealPrice,
                               @RequestParam("mealType") String mealType,
                               @RequestParam("mealImage") MultipartFile file,
                               @PathVariable("id") int id) throws IOException {
        return menuService.updateMenuById(mealName, mealPrice, mealType, file, id);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete-menu/{id}")
    public void deleteMenuById(@PathVariable("id") int id) {
        menuService.deleteMenuById(id);
    }
}
