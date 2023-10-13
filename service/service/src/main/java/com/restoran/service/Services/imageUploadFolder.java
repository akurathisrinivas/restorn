package com.restoran.service.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


import org.springframework.web.multipart.MultipartFile;


public interface imageUploadFolder {
	
	public void init();

	  public void save(MultipartFile file,String fileName);

	  public org.springframework.core.io.Resource load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
	  
	  public boolean delete(String filename);

}
