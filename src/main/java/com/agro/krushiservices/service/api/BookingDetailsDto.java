package com.agro.krushiservices.service.api;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "booking_details")
@Data
public class BookingDetailsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "booking_worker",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "worker_id")
    )
    private List<WorkerDetailsDto> workerDetailsDtoList;

    @Column(name = "billable_amount")
    private Double billableAmount;
}
