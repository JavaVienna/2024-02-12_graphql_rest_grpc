package com.posedio.roombooking.api.rest;

import com.posedio.roombooking.entity.HotelRoom;
import com.posedio.roombooking.service.HotelRoomsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotelrooms")
public class HotelRoomsController {

    private final HotelRoomsService service;
    public HotelRoomsController(HotelRoomsService service) {
        this.service = service;
    }

    @GetMapping
    public List<HotelRoom> getAllRooms() {
        return service.getAllRooms();
    }

}
