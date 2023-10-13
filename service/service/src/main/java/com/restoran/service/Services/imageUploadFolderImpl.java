package com.restoran.service.Services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class imageUploadFolderImpl implements imageUploadFolder {

	 private final Path root = Paths.get("uploads");
	 
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
		      Files.createDirectories(root);
		    } catch (IOException e) {
		      throw new RuntimeException("Could not initialize folder for upload!");
		    }

	}

	@Override
	public void save(MultipartFile file,String modifiedFileName) {
		// TODO Auto-generated method stub
		try {
		    //Date date = new Date();

	      //Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		 Files.copy(file.getInputStream(), this.root.resolve(modifiedFileName));

		} catch (Exception e) {
	      if (e instanceof FileAlreadyExistsException) {
	        throw new RuntimeException("A file of that name already exists.");
	      }

	      throw new RuntimeException(e.getMessage());
	    }

	}

	@Override
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
		      Path file = root.resolve(filename);
		      Resource resource = new UrlResource(file.toUri());

		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		FileSystemUtils.deleteRecursively(root.toFile());

	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		try {
		      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		    } catch (IOException e) {
		      throw new RuntimeException("Could not load the files!");
		    }
	}
	
	@Override
	  public boolean delete(String filename) {
	    try {
	      Path file = root.resolve(filename);
	      return Files.deleteIfExists(file);
	    } catch (IOException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }
}
