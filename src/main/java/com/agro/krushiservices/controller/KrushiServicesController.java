package com.agro.krushiservices.controller;

import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("krushionweb/v1")
public interface KrushiServicesController {

    @PostMapping("/booklaborers")
    ResponseEntity<BookingDetailsDto> bookLaborers(@RequestBody @Valid BookingDetails bookingDetails);
}
