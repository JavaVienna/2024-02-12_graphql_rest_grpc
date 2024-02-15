package com.posedio.roombooking.api.rest;

import com.posedio.roombooking.entity.Guest;
import com.posedio.roombooking.service.GuestsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/api/v1/guests")
public class GuestsController {


    private final GuestsService service;

    public GuestsController(GuestsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return service.getAllGuests();
    }

}
