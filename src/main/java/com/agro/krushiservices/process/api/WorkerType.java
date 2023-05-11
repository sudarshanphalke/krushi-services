package com.agro.krushiservices.process.api;

public enum WorkerType {

    HEAVY_WORKER(500.00),

    REGULAR_WORKER(200.00);

    Double amountPerDay;

    WorkerType(Double amountPerDay) {
        this.amountPerDay = amountPerDay;
    }

    public Double getAmountPerDay() {
        return amountPerDay;
    }
}
