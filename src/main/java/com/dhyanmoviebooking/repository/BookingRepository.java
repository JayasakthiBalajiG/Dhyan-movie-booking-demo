package com.dhyanmoviebooking.repository;

import com.dhyanmoviebooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findBookingByBookingid(Integer bookingid);

}
