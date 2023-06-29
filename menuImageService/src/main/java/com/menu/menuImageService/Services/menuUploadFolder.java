package com.menu.menuImageService.Services;

import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;



public interface menuUploadFolder {

	
	 public void init();

	  public void save(MultipartFile file);

	  public org.springframework.core.io.Resource load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
}
