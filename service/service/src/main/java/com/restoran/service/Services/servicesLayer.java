package com.restoran.service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restoran.service.Models.services;
import com.restoran.service.Repository.serviceRepository;

@Service
public class servicesLayer {
	
	@Autowired
	public serviceRepository servicerepo;
	
	
	  public services addServicetoDB(services svc) {
	  
	     return this.servicerepo.save(svc); 
		  }
	 
}
