package com.restoran.service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.restoran.service.Services.imageUploadFolderImpl;
//import com.restoran.service.Repository.serviceRepository;
import com.restoran.service.Services.servicesLayer;
import com.restoran.service.payload.LastIdResponse;
import com.restoran.service.payload.MessageResponse;

import com.restoran.service.Dto.servicesResponse;
import com.restoran.service.Models.services;
import com.restoran.service.Repository.serviceRepository;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/services")
public class serviceController {
	

	@Autowired
	public servicesLayer serviceLayer;
	
	@Autowired
	private imageUploadFolderImpl  uploadfolderservice;
	
	@Autowired
	public serviceRepository servicerepo;
	
	@PostMapping("/addservices")
	public ResponseEntity<LastIdResponse> addServices(@Valid @RequestBody services svc) {
		
		services addedservice= this.serviceLayer.addServicetoDB(svc);
		//services addedservice= this.servicerepo.save(svc);

		
		//return addedservice;
		int last_id=this.serviceLayer.getlastid();
		
		return ResponseEntity.ok(new LastIdResponse(last_id,"Added Successfully"));
		
	}
	
	@PostMapping("/uploadserviceimage")
	  public ResponseEntity<MessageResponse> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("service_id") Long service_id) {
	   
		String message = "";
	    try {
	      
	      
		  //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    	
	    	String fileName = file.getOriginalFilename();
	    	Date date = new Date();
		    String modifiedFileName = date.getTime()+fileName;
		    
		    serviceLayer.store(file,modifiedFileName,service_id);
	        uploadfolderservice.save(file,modifiedFileName);

	      message = "Uploaded the file successfully: " + modifiedFileName;
	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
	    }
	  }

	@GetMapping("/allservices")
	  public ResponseEntity<List<servicesResponse>> getAllServices() {
		
		List<services> serviceData=this.serviceLayer.getAllservicesData();
		
		
		
		List<servicesResponse> servicefiles=serviceData.stream().map(e -> {
		
			 String iconurl = null;

		if(e.getIcon() != null ) {
		 iconurl = MvcUriComponentsBuilder
          .fromMethodName(serviceController.class, "getFile", e.getIcon().toString()).build().toString();
			}
			
		return new servicesResponse(
				 
				 e.getId(),
				 e.getTitle(),
				 e.getShort_description(),
				 e.getLong_description(),
				 e.getCreatedDate(),
				 e.getStatus(),
				 iconurl,
				 e.getIcon_class()
				 
				 );
				
				
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(servicefiles);
		
	}
	
	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
	    Resource file = uploadfolderservice.load(filename);
	    return ResponseEntity
      .ok()
      .contentType(MediaType.IMAGE_JPEG)
      .body(new InputStreamResource(file.getInputStream()));
	  }
	  
	  
	  @GetMapping("/getServiceById/{id}")
	  public servicesResponse getService(@PathVariable Long id) {
	  
	   services servicedbData=this.serviceLayer.getServiceById(id);
	   
	   
	   String iconurl = null;

		if(servicedbData.getIcon() != null ) {
			 iconurl = MvcUriComponentsBuilder
	          .fromMethodName(serviceController.class, "getFile", servicedbData.getIcon().toString()).build().toString();
		}
			 return new servicesResponse(
					 
					 servicedbData.getId(),
					 servicedbData.getTitle(),
					 servicedbData.getShort_description(),
					 servicedbData.getLong_description(),
					 servicedbData.getCreatedDate(),
					 servicedbData.getStatus(),
					 iconurl,
					 servicedbData.getIcon_class()
					 
					 );	
			
	   
	  }
	  
	  @PatchMapping("/updateServicePartially/{id}")
	  public ResponseEntity<services> patch(@PathVariable Long id,@RequestBody Map<Object,Object> fileds){
		  Optional<services> service= this.serviceLayer.getfindById(id);
		  
		  if(service.isPresent()) {
			  fileds.forEach((key, value)->{
				  Field field= ReflectionUtils.findRequiredField(services.class, (String) key);
			      field.setAccessible(true);
			      ReflectionUtils.setField(field, service.get(), value);
			  });
			  
		  }
		  
		  services upservice= this.servicerepo.saveAndFlush(service.get());
		  
		  return new ResponseEntity<>(upservice, HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/deleteService/{id}")
	  public List<services> deleteServicebyId(@PathVariable Long id){
		  
		   
		   
		   Optional<services> service= this.serviceLayer.getfindById(id);
		   
		   String filename= service.get().getIcon();
		   
		   this.serviceLayer.deleteService(id);
		   uploadfolderservice.delete(filename);
		   
		   return this.serviceLayer.getAllservicesData();
		   
	  }

}
