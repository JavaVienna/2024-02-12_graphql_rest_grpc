package com.posedio.roombooking.api.graphql;

import com.posedio.roombooking.entity.HotelRoom;
import com.posedio.roombooking.service.HotelRoomsService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HotelRoomsGraphQLController {

    private final HotelRoomsService service;

    public HotelRoomsGraphQLController(HotelRoomsService service) {
        this.service = service;
    }

    @QueryMapping(name = "hotelRooms")
    public List<HotelRoom> getHotelRoom() {
        return service.getAllRooms();
    }
}
