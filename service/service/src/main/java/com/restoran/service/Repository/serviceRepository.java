package com.restoran.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restoran.service.Models.services;


@Repository
public interface serviceRepository extends JpaRepository<services, Long> {


	//com.restoran.service.Services.servicesLayer save(com.restoran.service.Services.servicesLayer svc);

}
