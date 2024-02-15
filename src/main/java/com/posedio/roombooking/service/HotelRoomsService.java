package com.posedio.roombooking.service;

import com.posedio.roombooking.entity.HotelRoom;
import com.posedio.roombooking.repository.HotelRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelRoomsService {
    private final HotelRoomRepository repository;

    public HotelRoomsService(HotelRoomRepository repository) {
        this.repository = repository;
    }


    public List<HotelRoom> getAllRooms() {
        return repository.findAll();
    }
}
