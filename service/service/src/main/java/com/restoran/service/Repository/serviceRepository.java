package com.restoran.service.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restoran.service.Models.services;


@Repository
public interface serviceRepository extends JpaRepository<services, Long> {


	//com.restoran.service.Services.servicesLayer save(com.restoran.service.Services.servicesLayer svc);
	@Transactional
	@Modifying
	@Query("update services u set u.icon = ?1 where u.id = ?2")
	int setimagenameForService(String icon, Long id);
}
