package com.restoran.bookings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.restoran.bookings.models.Bookings;
import com.restoran.bookings.repository.BookingRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/bookings")
public class BookingsController {
  
	
	 @Autowired
	 BookingRepository bookingRepository;
	 
	 @PostMapping("/save")
		public ResponseEntity<?> saveMenu(@Valid @RequestBody Bookings booking){
			System.out.println(booking);
			
			bookingRepository.save(booking);
			return ResponseEntity.ok("Booking table successfully!");
		}
}
