package com.posedio.roombooking.service;

import com.posedio.roombooking.entity.Guest;
import com.posedio.roombooking.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestsService {

    private final GuestRepository guestRepository;

    public GuestsService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

}
