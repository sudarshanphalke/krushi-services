package com.agro.krushiservices.service.api;

import com.agro.krushiservices.process.api.WorkerType;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class WorkerDetailsDto {

    private String workerName;

    private List<Date> reservedDates = new ArrayList<>();

    private WorkerType workerType;
}
