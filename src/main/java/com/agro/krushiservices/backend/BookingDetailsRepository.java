package com.agro.krushiservices.backend;

import com.agro.krushiservices.service.api.BookingDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetailsDto, Long> {
}
