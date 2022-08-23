package com.springexercise.springexercise.service.impl;

import com.springexercise.springexercise.dto.builder.WorkerV2Dto;
import com.springexercise.springexercise.entity.Worker;
import com.springexercise.springexercise.mapper.WorkerDtoMapper;
import com.springexercise.springexercise.repository.WorkerRepo;
import com.springexercise.springexercise.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerServiceimpl extends Thread implements WorkerService {


    private final WorkerDtoMapper workerDtoMapper;
    private final WorkerRepo workerRepo;

    @Override
    public List<WorkerV2Dto> getWorker() {

        List<WorkerV2Dto> workerV2Dtos = workerDtoMapper.mapListDto2(workerRepo.findAll());
        return workerV2Dtos;
    }










   /* private final WorkerRepo workerrepository;

    private final DeparmentRepo deparmentRepo;

    private final WorkerDtoMapper mapper;


    @Override
    public WorkerV2Dto saveDto(WorkerV2Dto workerV2Dto) {

        Worker worker = mapper.convertToEntityV2(workerV2Dto);//Dto'dan entitye
        WorkerV2Dto workerV2Dto1 = mapper.convertToDto1(workerrepository.save(worker)); //gelen entity to dto
        return workerV2Dto1;

    }


    @Override
    public List<WorkerV2Dto> filterService(WorkerV2Dto workerDto, Pageable pageable) {
        Worker worker = mapper.convertToEntityV2(workerDto);
        return null;
    }

    @Override
    public List<WorkerV2Dto> findAllAge(Long age,Pageable pageable) {
        return mapper.mapList(workerrepository.findByAgeLessThanEqual(age,pageable));
    }

    @Transactional
    @Override
    public WorkerV2Dto save(WorkerV2Dto workerV2Dto) {
        Worker worker=mapper.convertToEntityV2(workerV2Dto);
        Worker save = workerrepository.save(worker);
        WorkerV2Dto workerV2Dto1=mapper.convertToDto1(save);
        return workerV2Dto1;
    }
*/

}


