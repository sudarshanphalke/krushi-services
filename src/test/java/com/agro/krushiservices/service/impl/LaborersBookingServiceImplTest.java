package com.agro.krushiservices.service.impl;

import com.agro.krushiservices.backend.BookingDetailsRepository;
import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.process.api.WorkerDetails;
import com.agro.krushiservices.process.api.WorkerType;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import com.agro.krushiservices.service.api.WorkerDetailsDto;
import com.agro.krushiservices.util.mapper.BookingDetailsDtoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LaborersBookingServiceImplTest {

    @Mock
    private BookingDetailsDtoMapper bookingDetailsDtoMapper;

    @Mock
    private BookingDetailsRepository bookingDetailsRepository;
    
    @InjectMocks
    private LaborersBookingServiceImpl laborersBookingService;

    @Test
    public void bookLaborersTest() {
        // Prepare
        BookingDetailsDto bookingDetailsDto = new BookingDetailsDto();
        WorkerDetailsDto workerDetailsDto = new WorkerDetailsDto();
        workerDetailsDto.setWorkerName("Jane");
        workerDetailsDto.setReservedDates(Arrays.asList(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)
                , new Date()));
        workerDetailsDto.setWorkerType(WorkerType.REGULAR_WORKER);
        workerDetailsDto.setWorkerId(1L);
        WorkerDetailsDto workerDetail2 = new WorkerDetailsDto();
        workerDetail2.setWorkerName("John");
        workerDetail2.setReservedDates(List.of(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)));
        workerDetail2.setWorkerType(WorkerType.HEAVY_WORKER);
        workerDetail2.setWorkerId(2L);
        bookingDetailsDto.setBookingId(1L);
        bookingDetailsDto.setWorkerDetailsDtoList(List.of(workerDetailsDto, workerDetail2));
        when(bookingDetailsDtoMapper.toBookingDetailsDto(any())).thenReturn(bookingDetailsDto);
        when(bookingDetailsRepository.save(bookingDetailsDto)).thenReturn(bookingDetailsDto);

        BookingDetails bookingDetails = new BookingDetails();
        WorkerDetails workerDetails = new WorkerDetails();
        workerDetails.setWorkerName("Jane");
        workerDetails.setReservedDates(Arrays.asList(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)
                , new Date()));
        workerDetails.setWorkerType(WorkerType.REGULAR_WORKER);
        WorkerDetails workerDetails2 = new WorkerDetails();
        workerDetails2.setWorkerName("John");
        workerDetails2.setReservedDates(List.of(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)));
        workerDetails2.setWorkerType(WorkerType.HEAVY_WORKER);
        bookingDetails.setWorkerDetailsList(List.of(workerDetails, workerDetails2));

        // Act
        CompletableFuture<BookingDetailsDto> response = laborersBookingService.bookLaborers(bookingDetails);

        // Assert
        Assertions.assertEquals(936.0, response.join().getBillableAmount());
    }
}
