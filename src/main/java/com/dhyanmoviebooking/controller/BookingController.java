package com.dhyanmoviebooking.controller;

import com.dhyanmoviebooking.model.Booking;
import com.dhyanmoviebooking.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    //dependency injection
    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public List<Booking> getBooking(){
        return bookingRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity <List<Booking>> getBookingById (@PathVariable("id") Integer bookingid){
        return ResponseEntity.ok(bookingRepository.findBookingByBookingid(bookingid));
    }

    record NewBookingRequest(
            Integer bookingid,
            Integer movieid,
            Integer userid
    ){}

    @PostMapping
    public void AddBooking(@RequestBody NewBookingRequest request){
        Booking booking = new Booking();
        booking.setBookingid(request.bookingid());
        booking.setMovieid(request.movieid());
        booking.setUserid(request.userid());
    }

    @DeleteMapping("{booking_id}")
    public void DeleteBooking(@PathVariable("booking_id") Integer booking_id){
        bookingRepository.deleteById(booking_id);
    }
}
