package com.posedio.roombooking.api.grpc;

import com.google.protobuf.Empty;
import com.posedio.roombooking.proto.guests.GuestReply;
import com.posedio.roombooking.proto.guests.GuestsGrpc;
import com.posedio.roombooking.proto.guests.GuestsReply;
import com.posedio.roombooking.service.GuestsService;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GuestServiceImpl extends GuestsGrpc.GuestsImplBase {

    private final GuestsService service;

    public GuestServiceImpl(GuestsService service) {
        this.service = service;
    }

    @Override
    public void fetchGuests(Empty request, StreamObserver<GuestsReply> responseObserver) {
        List<GuestReply> allGuests = service.getAllGuests().stream().map(it ->
                GuestReply.newBuilder()
                        .setAddress(it.getAddress())
                        .setEmail(it.getEmail())
                        .setFirstname(it.getFirstName())
                        .setLastname(it.getLastName())
                        .setId(it.getId())
                        .build()
        ).toList();


        GuestsReply.Builder replyBuilder = GuestsReply.newBuilder();



        for (int i = 0; i < allGuests.size(); i++) {
            GuestReply guest = allGuests.get(i);
            replyBuilder.addGuests(i, guest);
        }

        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
