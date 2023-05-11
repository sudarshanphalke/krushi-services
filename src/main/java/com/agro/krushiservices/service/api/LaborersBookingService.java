package com.agro.krushiservices.service.api;

import com.agro.krushiservices.process.api.BookingDetails;

import java.util.concurrent.CompletableFuture;

public interface LaborersBookingService {

    CompletableFuture bookLaborers(BookingDetails bookingDetails);
}
