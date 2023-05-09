package com.agro.krushiservices.process.api;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class BookingDetails implements Serializable {

    @NotNull
    List<WorkerDetails> workerDetailsList;

    @NotNull
    private Double billableAmount;
}
