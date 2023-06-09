package com.example.menuservice.repository;

import com.example.menuservice.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Menu,Long> {

    List<Menu> findByRestaurantId(Long i );

    List<Menu> findByNameContaining(String s);

}
