package com.restoran.bookings.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restoran.bookings.dao.BookingsDao;
import com.restoran.bookings.models.Bookings;
import com.restoran.bookings.repository.BookingRepository;
import com.restoran.bookings.services.BookingsService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/bookings")
public class BookingsController {
  
	
	 @Autowired
	 BookingRepository bookingRepository;
	 
	 @Autowired
	 BookingsService bookingsService;
	 
	 @PostMapping("/save")
		public Bookings saveMenu(@Valid @RequestBody Bookings booking){
			System.out.println(booking);
			
			Bookings bookings=bookingRepository.save(booking);
			return bookings;
			// ResponseEntity.ok(new Object());
			 //return ResponseEntity.ok("success");
		}
	 
	 @GetMapping("/list_bookings")
	  public List<Bookings> getAllBookings(){
		 
		List<Bookings> result= bookingsService.getAllBookings();
		
		return result;
	 }
	 
		
	  @GetMapping("getbookings/{id}") 
	  public BookingsDao getbookingById(@PathVariable Long id){
	  
	  //System.out.println(id);
	  Optional<Bookings> result = this.bookingsService.getBookingById(id); 
	  //returnresult; 
	  //System.out.println(result);
	  
	  BookingsDao bdr = new BookingsDao(
			  
			   result.get().getId(),
			   result.get().getBookingId(),
			   result.get().getDatetime(),
			   result.get().getCreatedDate(),
			   result.get().getEmail(),
			   result.get().getName(),
			   result.get().getPeople(),
			   result.get().getSpecialrequest()
			   
			  );
	  
	  return bdr; 
	  
	  }
	 
	 
}
