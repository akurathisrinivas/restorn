package com.menu.menuImageService.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.menu.menuImageService.DAO.menuImageLayer;
import com.menu.menuImageService.Message.ResponseFile;
import com.menu.menuImageService.Message.ResponseMessage;
import com.menu.menuImageService.Models.FileInfo;
import com.menu.menuImageService.Models.menuImage;
import com.menu.menuImageService.Repository.menuImageRepository;
import com.menu.menuImageService.Services.menuImageService;
import com.menu.menuImageService.Services.menuUploadFolderImpl;

import jakarta.validation.Valid;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/api/menuImages")
public class menuImageController {
	
	@Autowired
	
	private menuImageService storageService;
	
	@Autowired
	private menuUploadFolderImpl  uploadfolderservice;
	
	//@Autowired
	  //private menuImageRepository menuimagerepository;
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("menu_id") String menu_id) {
	   
		String message = "";
	    try {
	      storageService.store(file,menu_id);
	      uploadfolderservice.save(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	@GetMapping("/allMenuImages")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      //String fileDownloadUri = ServletUriComponentsBuilder
	        //  .fromCurrentContextPath()
	        //  .path("/files/")
	         // .path(dbFile.getName())
	        //  .toUriString();
	    	
	    	String url = MvcUriComponentsBuilder
	  	          .fromMethodName(menuImageController.class, "getFile", dbFile.getName().toString()).build().toString();
	  	      

	      return new ResponseFile(
	    	  dbFile.getMenuId(),
	          dbFile.getName(),
	          url,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	
	@GetMapping("/files2")
	  public ResponseEntity<List<FileInfo>> getListFiles1() {
	    List<FileInfo> fileInfos = uploadfolderservice.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(menuImageController.class, "getFile", path.getFileName().toString()).build().toString();
	      
	      
	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }
	
		/* // code for download image
		 * @GetMapping("/files/{filename:.+}")
		 * 
		 * @ResponseBody public ResponseEntity<Resource> getFile(@PathVariable String
		 * filename) { Resource file = uploadfolderservice.load(filename); return
		 * ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
		 * "attachment; filename=\"" + file.getFilename() + "\"").body(file); }
		 */
	
	
	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
	    Resource file = uploadfolderservice.load(filename);
	    return ResponseEntity
        .ok()
        .contentType(MediaType.IMAGE_JPEG)
        .body(new InputStreamResource(file.getInputStream()));
	  }
	  
		
		 @GetMapping(value="/getImagesByMenuId/{menuId}", produces="application/json") 
		 public  ResponseEntity<List<menuImageLayer>> findmenuinages(@PathVariable("menuId") String menuId) {
		  
		  
			 //menuImage menuImageData = storageService.getImgByMenuId(menu_id); 
			 
			 //return (List<menuImageLayer>) menuImageData;
		    //return menuImageData;
			 
			 //List<menuImageLayer> al = new ArrayList<>();
			 
			 List<menuImageLayer> resData = storageService.findBymenuId(menuId).map( res -> {
			 
				 String url = MvcUriComponentsBuilder
			  	          .fromMethodName(menuImageController.class, "getFile", res.getName().toString()).build().toString();
			  	      
			 
			   return new menuImageLayer(
					   res.getId(), 
					   res.getMenuId(), 
					   url);
			   
			   
		               }).collect(Collectors.toList());
			 return ResponseEntity.status(HttpStatus.OK).body(resData);
			 
			 //resData.stream().map( res -> {
				 
					
				   
				 
			 //}).collect(Collectors.toList());

				/*
				 * if (tutorialData.isPresent()) { return new
				 * ResponseEntity<>(tutorialData.get(), HttpStatus.OK); } else { return new
				 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
				 */
			 
			 
		       
				 
			 //return resData;
			  
		  }
		 
	  
}
