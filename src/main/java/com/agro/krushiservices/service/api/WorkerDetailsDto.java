package com.agro.krushiservices.service.api;

import com.agro.krushiservices.process.api.WorkerType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "worker_details")
@Data
public class WorkerDetailsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "worker_name")
    private String workerName;

    @ElementCollection
    @CollectionTable(name = "worker_reserved_dates",
            joinColumns = @JoinColumn(name = "worker_id"))
    @Column(name = "reserved_date")
    private List<Date> reservedDates = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "worker_type")
    private WorkerType workerType;
}