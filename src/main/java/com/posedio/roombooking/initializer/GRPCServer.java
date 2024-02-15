package com.posedio.roombooking.initializer;

import com.posedio.roombooking.api.grpc.GuestServiceImpl;
import com.posedio.roombooking.entity.Booking;
import com.posedio.roombooking.entity.Guest;
import com.posedio.roombooking.entity.HotelRoom;
import com.posedio.roombooking.repository.BookingRepository;
import com.posedio.roombooking.repository.GuestRepository;
import com.posedio.roombooking.repository.HotelRoomRepository;
import com.posedio.roombooking.service.GuestsService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
public class GRPCServer {

    private final GuestsService guestService;

    public GRPCServer(GuestsService guestService) {
        this.guestService = guestService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startGRPCServer() {
        try {
            Server server = ServerBuilder
                    .forPort(8089)
                    .addService(new GuestServiceImpl(guestService)).build();

            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
