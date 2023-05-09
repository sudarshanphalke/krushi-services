package com.agro.krushiservices.service.impl;

import com.agro.krushiservices.backend.BookingDetailsRepository;
import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import com.agro.krushiservices.service.api.LaborersBookingService;
import com.agro.krushiservices.util.mapper.BookingDetailsDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class LaborersBookingServiceImpl implements LaborersBookingService {

    private final BookingDetailsDtoMapper bookingDetailsDtoMapper;

    private final BookingDetailsRepository bookingDetailsRepository;

    public LaborersBookingServiceImpl(BookingDetailsDtoMapper bookingDetailsDtoMapper,
                                      BookingDetailsRepository bookingDetailsRepository) {
        this.bookingDetailsDtoMapper = bookingDetailsDtoMapper;
        this.bookingDetailsRepository = bookingDetailsRepository;
    }

    @Override
    public String bookLaborers(BookingDetails bookingDetails) {
        BookingDetailsDto bookingDetailsDto = bookingDetailsDtoMapper.toBookingDetailsDto(bookingDetails);
        bookingDetailsRepository.save(bookingDetailsDto);
        return null;
    }
}
