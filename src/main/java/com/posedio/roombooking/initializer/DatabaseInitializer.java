package com.posedio.roombooking.initializer;

import com.posedio.roombooking.entity.Booking;
import com.posedio.roombooking.entity.Guest;
import com.posedio.roombooking.entity.HotelRoom;
import com.posedio.roombooking.repository.BookingRepository;
import com.posedio.roombooking.repository.GuestRepository;
import com.posedio.roombooking.repository.HotelRoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
public class DatabaseInitializer {

    private final GuestRepository guestRepository;
    private final HotelRoomRepository hotelRoomRepository;
    private final BookingRepository bookingRepository;

    public DatabaseInitializer(GuestRepository guestRepository, HotelRoomRepository hotelRoomRepository, BookingRepository bookingRepository) {
        this.guestRepository = guestRepository;
        this.hotelRoomRepository = hotelRoomRepository;
        this.bookingRepository = bookingRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDBWithMockValues() {
        Guest guest = new Guest(UUID.randomUUID().toString(), "Bruce", "Wayne", "bruce@batman.com", "Gotham");
        guestRepository.save(guest);
        Optional<Guest> savedGuest = guestRepository.findById(guest.getId());
        System.out.println(savedGuest.map(it -> "Guest is: " + it).orElse("Guest not found"));

        HotelRoom room = new HotelRoom(UUID.randomUUID().toString(), "King Suite", "The best Gotham has to offer");
        hotelRoomRepository.save(room);
        Optional<HotelRoom> savedRoom = hotelRoomRepository.findById(room.getId());
        System.out.println(savedRoom.map(it -> "Hotel room is: " + it).orElse("Hotel room not found"));

        Booking booking = new Booking(
                UUID.randomUUID().toString(),
                savedRoom.get(),
                savedGuest.get(),
                LocalDateTime.now().plusDays(3).withHour(15).withMinute(0).withSecond(0),
                LocalDateTime.now().plusDays(4).withHour(0).withMinute(0).withSecond(0),
                LocalDateTime.now().plusDays(7).withHour(9).withMinute(0).withSecond(0),
                LocalDateTime.now().plusDays(7).withHour(12).withMinute(0).withSecond(0),
                "Dark themed room",
                "I think this is batman"
        );
        bookingRepository.save(booking);
        Optional<Booking> savedBooking = bookingRepository.findById(booking.getId());
        System.out.println(savedBooking.map(it -> "Booking is: " + it).orElse("Booking not found"));
    }
}
