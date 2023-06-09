package com.example.menuservice.service;


import com.example.menuservice.model.Menu;
import com.example.menuservice.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    Repository repository;

    public List<Menu> menuList(){
        return repository.findAll();
    }

    public List<Menu> getByRestroID(Long l){
        return repository.findByRestaurantId(l);
    }

    public List<Menu> getBySearchContain(String s){
        return repository.findByNameContaining(s);
    }

}
