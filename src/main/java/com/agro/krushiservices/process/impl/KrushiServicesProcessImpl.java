package com.agro.krushiservices.process.impl;

import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.process.api.KrushiServicesProcess;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import com.agro.krushiservices.service.api.LaborersBookingService;
import org.springframework.stereotype.Component;

@Component
public class KrushiServicesProcessImpl implements KrushiServicesProcess {

    private final LaborersBookingService laborersBookingService;

    public KrushiServicesProcessImpl(LaborersBookingService laborersBookingService) {
        this.laborersBookingService = laborersBookingService;
    }

    @Override
    public BookingDetailsDto bookLaborers(BookingDetails bookingDetails) {
        return laborersBookingService.bookLaborers(bookingDetails);
    }
}
