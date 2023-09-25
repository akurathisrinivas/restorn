package com.menu.menuImageService.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.menu.menuImageService.DAO.menuImageLayer;
import com.menu.menuImageService.Models.menuImage;
import com.menu.menuImageService.Repository.FileDBRepository;
import com.menu.menuImageService.Repository.menuImageRepository;

import org.springframework.util.StringUtils;


@Service
public class menuImageService {

	
	  @Autowired
	  private FileDBRepository fileDBRepository;
	  
	  @Autowired
	  private menuImageRepository menuimagerepository;
	  
	  public menuImage store(MultipartFile file,String menuId) throws IOException {
		  
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    //Date date = new Date();
		    //String fileName2 =date.getTime()+fileName;
		    
		    //menuImage menuImagedb = new menuImage(fileName, file.getContentType(), file.getBytes(), menuId);
		    menuImage menuImagedb = new menuImage(fileName, file.getContentType(), null , menuId);

		    return fileDBRepository.save(menuImagedb);
}
	  
	  public menuImage getFile(String id) {
		    return fileDBRepository.findById(id).get();
		  }
		  
		  public Stream<menuImage> getAllFiles() {
		    return fileDBRepository.findAll().stream();
		  }
		  
		 public Stream<menuImage> findBymenuId(String menuId) {
			
		     //List<menuImageLayer> al = new ArrayList<>();
		     
			  System.out.println(menuId);
			  
			  Stream<menuImage> store= menuimagerepository.findAllBymenuId(menuId).stream();
			  
			  System.out.println(store);
			  
			  //return menuimagerepository.findAllBymenuId(menuId).stream();
			  return store;
			  
		      //System.out.println(mI);
		     
//		     mI.forEach((p) ->{
//		            //System.out.println(p.getId());
//		            //System.out.println(p.getName());
//		    	 p.getId();
//		    	 p.getName();
//		    	 p.getCreatedDate();
//		    	 p.getType();
//		        });
		      //return mI;
		}
		  
		  
	  
}
