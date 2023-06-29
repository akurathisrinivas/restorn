package com.menu.menuService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.menuService.models.Menu;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	
}
