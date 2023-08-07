package com.menu.menuService.controllers;



import java.util.ArrayList;
import org.springframework.boot.web.client.RestTemplateBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.menu.menuService.Dto.menuImagesDto;
import com.menu.menuService.Dto.singleMenuOutputDto;
import com.menu.menuService.Enum.Status;
import com.menu.menuService.models.Menu;
import com.menu.menuService.repository.MenuRepository;
import com.menu.menuService.services.menuService;

import jakarta.persistence.EnumType;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api/menu")
public class MenuServiceController {
	
	@Autowired
	 MenuRepository menuRepository;
	
	@Autowired(required = true)
	menuService menuService;
	
	
	
	private RestTemplate restTemplate;
	
	private RestTemplateBuilder restTemplateBuilder;
	
	@PostMapping("/test")
	public String test() {
		
		return "srinivas";
	}
	
	
	@PostMapping("/savemenu")
	public ResponseEntity<?> saveMenu(@Valid @RequestBody Menu menu){
		System.out.println(menu);
		
		menuRepository.save(menu);
		return ResponseEntity.ok("Menu created successfully!");
	}
	
	@GetMapping("/getMenuById/{id}")
	public Object getmenuById(@PathVariable("id") Long id){
		
	
		RestTemplate restTemplate = new RestTemplate();
	   
        final String uri = "http://localhost:8082/api/menuImages/getImagesByMenuId/" +id;
		
		
		
		ResponseEntity<List> response = restTemplate.getForEntity(uri, List.class);
      
        List<menuImagesDto> menuImages = response.getBody();
        System.out.println(menuImages);
        
        Optional<Menu> menu = this.menuService.getMenuById(id);
        
        System.out.println(menu.get().getId());
        
         //menuOutput mu= new menuOutput(menu,menuImages);
        
       // HashMap<Integer, ArrayList<String>> menu = new HashMap<Integer, ArrayList<String>>();
         // menu.put("menuimages", menuImages);      
        	
        singleMenuOutputDto sdt= new singleMenuOutputDto(
        		menu.get().getId(),
        		menu.get().getPrice(),
        		menu.get().getShot_desc(),
        		menu.get().getTitle(),
        		menu.get().getType(),
        		menu.get().getCategory(),
        		
        		menuImages,
        		menu.get().getStatus()
        		);
        
       
       
       
        
	    return sdt;
	  
	//return restTemplate.getForObject(uri, menuImagesDto.class);
			// Object response = menuservice.getmenuImages(id);
			
		   //return response;
	  //ResponseEntity<menuImagesDto> response = restTemplate.getForEntity(
				 // "http://localhost:8082/api/menuImages/getImagesByMenuId/" +id ,
				 // menuImagesDto.class); 
					
					//final String uri = "http://localhost:8082/api/menuImages/getImagesByMenuId/" +id;
				     
				    
				     
				    //HttpHeaders headers = new HttpHeaders();
				    //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				    //HttpEntity<menuImagesDto> entity = new HttpEntity<menuImagesDto>(headers);
				    
				   // List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
				  //Add the Jackson Message converter
				 // MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

				  // Note: here we are making this converter to process any kind of response, 
				  // not only application/*json, which is the default behaviour
				  //converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
				 // messageConverters.add(converter);  
				  // restTemplate.setMessageConverters(messageConverters);
				     
				    //ResponseEntity<menuImagesDto> response = restTemplate.getForEntity(uri, menuImagesDto.class);
				 
				   //menuImagesDto menuimgesdto = response;
				
		/*
		 * try { menuImagesDto body = restTemplate.getForObject(uri,
		 * menuImagesDto.class); }catch (RestClientException e) { // current status just
		 * only throws RestClientException without body end search of for loop. without
		 * stream read. log.info("{}, {}", e.getClass().getCanonicalName(),
		 * e.getMessage());
		 * 
		 * // when modified, developer can check response body if (e instanceof
		 * RestClientResponseException){
		 * log.info("## No Suitable MessageConverter Body ##"); log.info("{}",
		 * ((RestClientResponseException) e).getResponseBodyAsString()); } }
		 */
	   //return menuRepository.findById(id);
		
	}
	
	@GetMapping("/getAllMenu")
	public List<Menu> getMenuAll(){
		
		List<Menu> menu = this.menuService.getMenuAllData();
		
	    return menu;
	}
	
	@DeleteMapping("/deleteMenu/{Id}")
	public List<Menu> deleteMenu(@PathVariable Long Id)
	{
	    return (List<Menu>) this.menuService.deleteMenuById(Id);    
	    
	}
	
	@GetMapping("/updateStatus/{Id}/{status}")
	public Optional<Menu> updateMenuStatus(@PathVariable Long Id,@PathVariable Status status)
	{
	    return (Optional<Menu>) this.menuService.updateMenuStatus(Id,status);    
	    
	}
	
	@PutMapping("updateMenu/{id}")
	public ResponseEntity<Object> updateMenu(@Valid @RequestBody Menu menu,@PathVariable long id){
		
		Optional<Menu> menu1 = this.menuService.getMenuById(id);
		if (menu1.isEmpty())
			return ResponseEntity.notFound().build();
		menu.setId(id);
		
		menuRepository.save(menu);
		
		//return ResponseEntity.noContent().build();
		return ResponseEntity.ok("Menu updated successfully!");
	}
	

}
