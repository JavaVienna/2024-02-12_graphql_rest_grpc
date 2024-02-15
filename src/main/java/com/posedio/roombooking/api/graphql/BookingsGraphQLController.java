package com.posedio.roombooking.api.graphql;

import com.posedio.roombooking.entity.Booking;
import com.posedio.roombooking.service.BookingsService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingsGraphQLController {

    private final BookingsService service;

    public BookingsGraphQLController(BookingsService service) {
        this.service = service;
    }

    @QueryMapping(name = "bookings")
    public List<Booking> getBookings() {
        return service.getAllBookings();
    }
}
