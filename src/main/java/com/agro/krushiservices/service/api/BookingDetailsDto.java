package com.agro.krushiservices.service.api;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserTypeLegacyBridge;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class BookingDetailsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Type(value = UserTypeLegacyBridge.class)
    @Column(name = "worker_details")
    private List<WorkerDetailsDto> workerDetailsDtoList = new ArrayList<>();

    @Column(name = "billable_amount")
    private Double billableAmount;
}
