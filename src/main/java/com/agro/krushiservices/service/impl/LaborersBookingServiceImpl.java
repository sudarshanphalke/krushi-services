package com.agro.krushiservices.service.impl;

import com.agro.krushiservices.backend.BookingDetailsRepository;
import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import com.agro.krushiservices.service.api.LaborersBookingService;
import com.agro.krushiservices.service.api.WorkerDetailsDto;
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
    public BookingDetailsDto bookLaborers(BookingDetails bookingDetails) {
        Double amount = 0.00;
        BookingDetailsDto bookingDetailsDto = bookingDetailsDtoMapper.toBookingDetailsDto(bookingDetails);
        for(WorkerDetailsDto workerDetails: bookingDetailsDto.getWorkerDetailsDtoList()) {
                amount += workerDetails.getWorkerType().getAmountPerDay() * workerDetails.getReservedDates().size();
        }
        System.out.println(amount);
        bookingDetailsDto.setBillableAmount(calculateFinalAmount(amount));
        return bookingDetailsRepository.save(bookingDetailsDto);
    }

    /**
     * This will add the commission and the GST in the amount (9% CGST, 9% SGST)
     *
     * @param amount {@link Double}
     */
    private Double calculateFinalAmount(Double amount) {
        //4% commission
        amount += amount * 0.04;

        return amount += amount * 0.18;
    }
}
