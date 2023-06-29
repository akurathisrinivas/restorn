package com.menu.menuImageService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.menu.menuImageService.DAO.menuImageLayer;
import com.menu.menuImageService.Models.menuImage;

@Repository
public interface menuImageRepository extends JpaRepository<menuImage, Long> {
	
	 //@Query("select e from menu_images e where e.menu_id = ?1")
	 //menuImage findByMenu_id(String menu_id);
	  List<menuImage> findByName(String name);
	  
	  //@Query("select e from menu_images e where e.menu_id = ?1")
	  List<menuImage> findAllBymenuId(String menuId);
}
