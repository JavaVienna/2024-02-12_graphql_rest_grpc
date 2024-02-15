package com.posedio.roombooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class HotelRoom {

    @Id
    private String id;
    // Is this an enum?
    private String Type;
    private String description;

    public HotelRoom(String id, String type, String description) {
        this.id = id;
        Type = type;
        this.description = description;
    }

    public HotelRoom() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return Objects.equals(id, hotelRoom.id) && Objects.equals(Type, hotelRoom.Type) && Objects.equals(description, hotelRoom.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Type, description);
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "id='" + id + '\'' +
                ", Type='" + Type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
