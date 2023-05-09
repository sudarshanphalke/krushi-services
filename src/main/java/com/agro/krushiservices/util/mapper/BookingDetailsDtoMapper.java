package com.agro.krushiservices.util.mapper;

import com.agro.krushiservices.process.api.BookingDetails;
import com.agro.krushiservices.service.api.BookingDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingDetailsDtoMapper {

    @Mapping(target = "bookingId", ignore = true)
    @Mapping(target = "workerDetailsDtoList", source = "workerDetailsList")
    BookingDetailsDto toBookingDetailsDto(BookingDetails bookingDetails);
}
