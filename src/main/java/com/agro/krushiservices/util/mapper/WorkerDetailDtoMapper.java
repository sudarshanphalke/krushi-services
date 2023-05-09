package com.agro.krushiservices.util.mapper;

import com.agro.krushiservices.process.api.WorkerDetails;
import com.agro.krushiservices.service.api.WorkerDetailsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkerDetailDtoMapper {

    WorkerDetailsDto toWorkerDetailsDto(WorkerDetails workerDetails);
}
