package com.posedio.roombooking.api.rest;

import com.posedio.roombooking.entity.Booking;
import com.posedio.roombooking.service.BookingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/bookings")
public class BookingsController {

    private final BookingsService bookingsService;

    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingsService.getAllBookings();
    }

}
