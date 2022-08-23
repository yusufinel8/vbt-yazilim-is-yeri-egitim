package com.springexercise.springexercise.service;

import com.springexercise.springexercise.dto.ResponsePayload;
import com.springexercise.springexercise.dto.builder.WorkerV2Dto;

import java.awt.print.Pageable;
import java.util.List;

public interface WorkerService {

/*    WorkerV2Dto saveDto(WorkerV2Dto workerV2Dto);

    List<WorkerV2Dto> filterService(WorkerV2Dto worker, Pageable pageable);

    List<WorkerV2Dto> findAllAge(Long id,Pageable pageable);

    WorkerV2Dto save(WorkerV2Dto workerV2Dto)*/;

    List<WorkerV2Dto> getWorker();

    List<WorkerV2Dto> filterService(WorkerV2Dto workerDto, Pageable pageable);
}
