package com.restoran.service.Services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.restoran.service.Models.services;
import com.restoran.service.Repository.serviceRepository;

@Service
public class servicesLayer {
	
	@Autowired
	public serviceRepository servicerepo;
	
	
	  public services addServicetoDB(services svc) {
	  
	     return this.servicerepo.save(svc); 
		  }
	  

	  public int store(MultipartFile file,String modifiedFileName,Long serviceId) throws IOException {
		  
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    //Date date = new Date();
		    //String fileName2 =date.getTime()+fileName;
		    //System.out.println(fileName);
		    //System.out.println(serviceId);

		    int value=this.servicerepo.setimagenameForService(modifiedFileName,serviceId);
		    //System.out.println(value);
		    
		    return value;
	  }
	  
	  public List<services> getAllservicesData() {
		 return this.servicerepo.findAll();
	  }
	  
	  public services getServiceById(Long id) {
		  
		  return this.servicerepo.findById(id).get();
	  }
	  
	  public Optional<services> getfindById(Long id){
		  
		   return this.servicerepo.findById(id);
		  
	  }
	  
	  public List<services> deleteService(Long id){
		  
	   
	   this.servicerepo.deleteById(id);
	   
	   return this.servicerepo.findAll();
	  }
	 
}
