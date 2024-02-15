package com.posedio.roombooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    private String id;
    @ManyToOne
    private HotelRoom hotelRoom;
    @ManyToOne
    private Guest guest;
    private LocalDateTime checkInFrom;
    private LocalDateTime checkInTo;
    private LocalDateTime checkOutFrom;
    private LocalDateTime checkOutTo;
    private String requests;
    private String internalNotes;

    public Booking(String id, HotelRoom hotelRoom, Guest guest, LocalDateTime checkInFrom, LocalDateTime checkInTo, LocalDateTime checkOutFrom, LocalDateTime checkOutTo, String requests, String internalNotes) {
        this.id = id;
        this.hotelRoom = hotelRoom;
        this.guest = guest;
        this.checkInFrom = checkInFrom;
        this.checkInTo = checkInTo;
        this.checkOutFrom = checkOutFrom;
        this.checkOutTo = checkOutTo;
        this.requests = requests;
        this.internalNotes = internalNotes;
    }

    public Booking() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HotelRoom getRoom() {
        return hotelRoom;
    }

    public void setRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDateTime getCheckInFrom() {
        return checkInFrom;
    }

    public void setCheckInFrom(LocalDateTime checkInFrom) {
        this.checkInFrom = checkInFrom;
    }

    public LocalDateTime getCheckInTo() {
        return checkInTo;
    }

    public void setCheckInTo(LocalDateTime checkInTo) {
        this.checkInTo = checkInTo;
    }

    public LocalDateTime getCheckOutFrom() {
        return checkOutFrom;
    }

    public void setCheckOutFrom(LocalDateTime checkOutFrom) {
        this.checkOutFrom = checkOutFrom;
    }

    public LocalDateTime getCheckOutTo() {
        return checkOutTo;
    }

    public void setCheckOutTo(LocalDateTime checkOutTo) {
        this.checkOutTo = checkOutTo;
    }

    public String getRequests() {
        return requests;
    }

    public void setRequests(String requests) {
        this.requests = requests;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", hotelRoom=" + hotelRoom +
                ", guest=" + guest +
                ", checkInFrom=" + checkInFrom +
                ", checkInTo=" + checkInTo +
                ", checkOutFrom=" + checkOutFrom +
                ", checkOutTo=" + checkOutTo +
                ", requests='" + requests + '\'' +
                ", internalNotes='" + internalNotes + '\'' +
                '}';
    }
}
