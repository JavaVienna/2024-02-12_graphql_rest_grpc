package com.posedio.roombooking.service;

import com.posedio.roombooking.entity.Booking;
import com.posedio.roombooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {

    private final BookingRepository bookingRepository;
    private final HotelRoomsService hotelRoomsService;
    private final GuestsService guestsService;


    public BookingsService(BookingRepository bookingRepository, HotelRoomsService hotelRoomsService, GuestsService guestsService) {
        this.bookingRepository = bookingRepository;
        this.hotelRoomsService = hotelRoomsService;
        this.guestsService = guestsService;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

}
