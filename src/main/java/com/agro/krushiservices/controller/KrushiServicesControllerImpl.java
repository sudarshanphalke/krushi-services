package com.agro.krushiservices.controller;

import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.process.api.KrushiServicesProcess;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KrushiServicesControllerImpl implements KrushiServicesController {

    KrushiServicesProcess krushiServicesProcess;

    public KrushiServicesControllerImpl(KrushiServicesProcess krushiServicesProcess) {
        this.krushiServicesProcess = krushiServicesProcess;
    }

    @Override
    public ResponseEntity<BookingDetailsDto> bookLaborers(@RequestBody @Valid BookingDetails bookingDetails) {
        BookingDetailsDto processResponse = krushiServicesProcess.bookLaborers(bookingDetails);
        return ResponseEntity.ok(processResponse);
    }
}
