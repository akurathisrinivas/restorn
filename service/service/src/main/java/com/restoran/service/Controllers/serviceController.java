package com.restoran.service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.restoran.service.Repository.serviceRepository;
import com.restoran.service.Services.servicesLayer;
import com.restoran.service.payload.MessageResponse;
import com.restoran.service.Models.services;

import javax.validation.Valid;



@RestController
@RequestMapping("/api/services")
public class serviceController {
	
	@Autowired
	public servicesLayer serviceLayer;
	
	//@Autowired
	//public serviceRepository servicerepo;
	
	@PostMapping("/addservices")
	public ResponseEntity<MessageResponse> addServices(@Valid @RequestBody services svc) {
		
		services addedservice= this.serviceLayer.addServicetoDB(svc);
		//services addedservice= this.servicerepo.save(svc);

		
		//return addedservice;
		return ResponseEntity.ok(new MessageResponse("Added Successfully"));
		
	}
	

}
