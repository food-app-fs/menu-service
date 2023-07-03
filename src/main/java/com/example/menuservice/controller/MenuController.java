package com.example.menuservice.controller;


import com.example.menuservice.model.Menu;
import com.example.menuservice.repository.Repository;
import com.example.menuservice.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RequestMapping("/menu/")
@Slf4j
@RestController
public class MenuController {

    @Autowired
    MenuService service;

    @Autowired
    Repository repository;

    @PostMapping("/add-new")
    public Menu addMenu(@RequestBody Menu menu){
        log.info("ADD MENU");
        return repository.save(menu);
    }

    @GetMapping("/{id}")
    public List<Menu> getMenuForRestaurantByID(@PathVariable("id") Long id){
        log.info("SEARCH BY ID: " + id);
        return service.getByRestroID(id);
    }

    @PostMapping("/search/{s}")
    public List<Menu> getMenuFromSearch(@PathVariable("s") String s) {
        log.info("SEARCH BY contain: " + s);
        return service.getBySearchContain(s);

    }

    @PostMapping("/search/menu-id")
    public List<String> provideMenuNameAsPerID(
            @RequestBody List<Long> data
            ){


        List<String> names = new ArrayList<>();
        List<Menu> menuList = repository.findAll();

        for(int i = 0 ; i < data.size(); i++){
            for(Menu menu: menuList){
                if(data.get(i).equals(menu.getProductId())){
                    names.add(menu.getName());
                }
            }
        }

        return names;

    }
}
