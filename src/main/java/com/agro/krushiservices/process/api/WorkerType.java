package com.agro.krushiservices.process.api;

public enum WorkerType {

    HEAVY_WORKER(200.00),

    REGULAR_WORKER(500.00);

    Double amountPerDay;

    WorkerType(Double amountPerDay) {
        this.amountPerDay = amountPerDay;
    }
}
