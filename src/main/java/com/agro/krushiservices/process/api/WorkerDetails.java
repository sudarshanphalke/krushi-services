package com.agro.krushiservices.process.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class WorkerDetails {

    private String workerName;

    private List<Date> reservedDates = new ArrayList<>();

    private WorkerType workerType;
}
