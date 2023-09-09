package com.restoran.bookings.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restoran.bookings.models.Bookings;
import com.restoran.bookings.repository.BookingRepository;

@Service
public class BookingsService {
	
	@Autowired
	 BookingRepository bookingRepository;
	
	public List<Bookings> getAllBookings(){
		 
		List<Bookings> result= bookingRepository.findAll();
		
		return result;
	 }
	 
   public Optional<Bookings> getBookingById(Long id){
	   
	   return bookingRepository.findById(id);
   }
}
