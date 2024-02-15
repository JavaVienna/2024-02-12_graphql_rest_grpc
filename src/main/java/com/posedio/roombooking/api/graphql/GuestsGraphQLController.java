package com.posedio.roombooking.api.graphql;

import com.posedio.roombooking.entity.Guest;
import com.posedio.roombooking.service.GuestsService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GuestsGraphQLController {

    private final GuestsService service;

    public GuestsGraphQLController(GuestsService service) {
        this.service = service;
    }

    @QueryMapping(name = "guests")
    public List<Guest> getGuests() {
        return service.getAllGuests();
    }
}
