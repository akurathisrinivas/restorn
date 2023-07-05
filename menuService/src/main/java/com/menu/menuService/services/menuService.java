package com.menu.menuService.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.menu.menuService.Dto.menuImagesDto;
import com.menu.menuService.models.Menu;
import com.menu.menuService.repository.MenuRepository;

@Service
public class menuService {
	
	@Autowired
	 MenuRepository menuRepository;
	
	private final RestTemplate restTemplate;

	public menuService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		this.restTemplate.setMessageConverters(messageConverters);
	}

	public Object getmenuImages(Long id) {
		final String uri = "http://localhost:8082/api/menuImages/getImagesByMenuId/" +id;
		
		return this.restTemplate.getForObject(uri, menuImagesDto.class);
	}
	
	public Optional<Menu> getMenuById(Long id) {
		
		return this.menuRepository.findById(id);
	}

}
