package com.menu.menuService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.menu.menuService.Enum.Status;
import com.menu.menuService.models.Menu;

import jakarta.transaction.Transactional;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	@Modifying
	@Transactional
	@Query(value = "update menu set status = ?2 where id = ?1", nativeQuery = true)
	int updateStatus(Long id, int status);
}
