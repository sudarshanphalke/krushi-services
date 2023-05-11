package com.agro.krushiservices.process.api;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BookingDetails {

    @NotNull
    List<WorkerDetails> workerDetailsList;

}
