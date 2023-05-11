package com.agro.krushiservices.service.impl;

import com.agro.krushiservices.backend.BookingDetailsRepository;
import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import com.agro.krushiservices.service.api.LaborersBookingService;
import com.agro.krushiservices.service.api.WorkerDetailsDto;
import com.agro.krushiservices.util.mapper.BookingDetailsDtoMapper;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class LaborersBookingServiceImpl implements LaborersBookingService {

    public static final String LABORER_BOOKING_SERVICE = "laborerBookingService";
    public static final String BOOK_LABORERS_FALLBACK = "bookLaborersFallback";
    private final BookingDetailsDtoMapper bookingDetailsDtoMapper;

    private final BookingDetailsRepository bookingDetailsRepository;

    public LaborersBookingServiceImpl(BookingDetailsDtoMapper bookingDetailsDtoMapper,
                                      BookingDetailsRepository bookingDetailsRepository) {
        this.bookingDetailsDtoMapper = bookingDetailsDtoMapper;
        this.bookingDetailsRepository = bookingDetailsRepository;
    }

    @Override
    @CircuitBreaker(name = LABORER_BOOKING_SERVICE, fallbackMethod = BOOK_LABORERS_FALLBACK)
    @Bulkhead(name = LABORER_BOOKING_SERVICE, fallbackMethod = BOOK_LABORERS_FALLBACK)
    @TimeLimiter(name = LABORER_BOOKING_SERVICE, fallbackMethod = BOOK_LABORERS_FALLBACK)
    @Async
    public CompletableFuture<BookingDetailsDto> bookLaborers(BookingDetails bookingDetails) {
        return CompletableFuture.supplyAsync(() -> asyncBookLaborers(bookingDetails));
    }

    private BookingDetailsDto asyncBookLaborers(BookingDetails bookingDetails) {
        Double amount = 0.00;
        BookingDetailsDto bookingDetailsDto = bookingDetailsDtoMapper.toBookingDetailsDto(bookingDetails);
        for(WorkerDetailsDto workerDetails: bookingDetailsDto.getWorkerDetailsDtoList()) {
                amount += workerDetails.getWorkerType().getAmountPerDay() * workerDetails.getReservedDates().size();
        }
        System.out.println(amount);
        bookingDetailsDto.setBillableAmount(calculateFinalAmount(amount));
        return bookingDetailsRepository.save(bookingDetailsDto);
    }

    public BookingDetailsDto bookLaborersFallback() {
        log.error("LaborersBookingServiceImpl is running into fallback, returning an empty object");
        return new BookingDetailsDto();
    }
    /**
     * This will add the commission in the amount
     *
     * @param amount {@link Double}
     */
    private Double calculateFinalAmount(Double amount) {
        //4% commission
        amount += amount * 0.04;
        return amount;
    }
}
