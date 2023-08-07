package com.restoran.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restoran.bookings.models.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {

}
