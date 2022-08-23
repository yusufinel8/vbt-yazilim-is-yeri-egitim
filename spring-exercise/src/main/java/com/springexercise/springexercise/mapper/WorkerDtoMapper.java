package com.springexercise.springexercise.mapper;

import com.springexercise.springexercise.dto.builder.DepartmentV2Dto;
import com.springexercise.springexercise.dto.builder.WorkerV2Dto;
import com.springexercise.springexercise.entity.Department;
import com.springexercise.springexercise.entity.Worker;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class WorkerDtoMapper {


    public Worker convertToEntity(WorkerV2Dto workerV2Dto) {

        DepartmentDtoMapper departmentDtoMapper = new DepartmentDtoMapper();

        Department department = departmentDtoMapper.convertToEntity(workerV2Dto.getDepartment());

        return Worker.builder()
                .id(workerV2Dto.getId())
                .firstName(workerV2Dto.getFirstname())
                .lastName(workerV2Dto.getLastname())
                .age(workerV2Dto.getAge())
                .gender(workerV2Dto.getGender())
                .departmentId(setEntiyId(department))
                .build();
    }

    public WorkerV2Dto convertToDto(Worker worker) {

        DepartmentDtoMapper departmentDtoMapper = new DepartmentDtoMapper();
        return WorkerV2Dto.builder()
                .id(worker.getId())
                .firstname(worker.getFirstName())
                .lastname(worker.getLastName())
                .age(worker.getAge())
                .gender(worker.getGender())
                .department(setDtoId(departmentDtoMapper.convertToDto(worker.getDepartmentId())))
                .build();
    }

    public List<WorkerV2Dto> mapListDto2(List<Worker> worker) {
        List<WorkerV2Dto> maplist = new ArrayList<>();
        for (Worker work : worker) {
            maplist.add(convertToDto(work));
        }
        return maplist;

    }

    public List<Worker> mapListEntiy2(List<WorkerV2Dto> workerV2Dtos){
        List<Worker> maplist=new ArrayList<>();
        for(WorkerV2Dto workerV2Dto:workerV2Dtos){
            workerV2Dto.setDepartment(null);
            maplist.add(convertToEntity(workerV2Dto));
        }
        return maplist;
    }






    public Department setEntiyId(Department department){
        department.setWork(null);
        return department;
    }
    public DepartmentV2Dto setDtoId(DepartmentV2Dto departmentV2Dto){
        departmentV2Dto.setWork(null);
        return departmentV2Dto;
    }
    public List<Department> setListEntityId(List<Department> department) {

        for (Department department1 : department) {
            department1.setWork(null);
        }
        return department;
    }
    public List<DepartmentV2Dto> setListDtoId(List<DepartmentV2Dto> department) {

        for (DepartmentV2Dto department1 : department) {
            department1.setWork(null);
        }
        return department;
    }













    //1
    public Worker convertToEntityV2(WorkerV2Dto workerV2Dto) {

        DepartmentDtoMapper departmentDtoMapper = new DepartmentDtoMapper();

        return Worker.builder()
                .id(workerV2Dto.getId())
                .firstName(workerV2Dto.getFirstname())
                .lastName(workerV2Dto.getLastname())
                .age(workerV2Dto.getAge())
                .departmentId(departmentDtoMapper.convertToEntityToDepartment(workerV2Dto.getDepartment()))
                .gender(workerV2Dto.getGender())
                .build();
    }





    //2
    public WorkerV2Dto convertToDto1(Worker worker) {

        DepartmentDtoMapper departmentDtoMapper = new DepartmentDtoMapper();

        return WorkerV2Dto.builder()
                .id(worker.getId())
                .age(worker.getAge())
                .department(departmentDtoMapper.converToDtoToDepartment1((worker.getDepartmentId())))
                .firstname(worker.getFirstName())
                .lastname(worker.getLastName())
                .gender(worker.getGender())
                .build();
    }

    public WorkerV2Dto convertToDto2(Worker worker) {

        return WorkerV2Dto.builder()
                .id(worker.getId())
                .age(worker.getAge())
                .firstname(worker.getFirstName())
                .lastname(worker.getLastName())
                .gender(worker.getGender())
                .build();
    }

    public List<WorkerV2Dto> mapList(List<Worker> worker) {
        List<WorkerV2Dto> maplist = new ArrayList<>();
        for (Worker work : worker) {
            maplist.add(convertToDto1(work));
        }
        return maplist;

    }

    public List<Worker> mapListToEntity(List<WorkerV2Dto> workerV2Dtos) {
        List<Worker> map = new ArrayList<>();
        for (WorkerV2Dto workerV2Dto : workerV2Dtos) {
            map.add(convertToEntityV2(workerV2Dto));
        }
        return map;

    }


}



