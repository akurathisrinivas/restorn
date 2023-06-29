package com.menu.menuImageService.Repository;




import org.springframework.data.jpa.repository.JpaRepository;


import com.menu.menuImageService.Models.menuImage;


public interface FileDBRepository extends JpaRepository<menuImage, String> {

    
	//@Transactional
	//@Modifying
	//@Query("select e from menu_images e where e.menu_id = ?1")
	//List<menuImage> findByMenuId(String menu_id);

}
