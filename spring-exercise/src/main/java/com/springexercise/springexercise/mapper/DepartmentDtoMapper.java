package com.springexercise.springexercise.mapper;

import com.springexercise.springexercise.dto.builder.DepartmentV2Dto;
import com.springexercise.springexercise.dto.builder.WorkerV2Dto;
import com.springexercise.springexercise.entity.Department;
import com.springexercise.springexercise.entity.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DepartmentDtoMapper {

    public Department convertToEntity(DepartmentV2Dto departmentV2Dto) {
        WorkerDtoMapper workerDtoMapper = new WorkerDtoMapper();
        return Department.builder()
                .id(departmentV2Dto.getId())
                .name(departmentV2Dto.getDepartmentname())
                .section(departmentV2Dto.getSection())
                .salary(departmentV2Dto.getBlock())
                .block(departmentV2Dto.getBlock())
                .work(workerDtoMapper.mapListEntiy2(departmentV2Dto.getWork()))
                .build();
    }
    public DepartmentV2Dto convertToDto(Department department) {
        ProjectDtoMapper projectDtoMapper = new ProjectDtoMapper();
        return DepartmentV2Dto.builder()
                .id(department.getId())
                .block(department.getBlock())
                .salary(department.getSalary())
                .section(department.getSection())
                .departmentname(department.getName())
                .project(projectDtoMapper.convertToDtoToProject(department.getProject()))
                .build();
    }

    public List<DepartmentV2Dto> mapListToDto(List<Department> departments) {

        List<DepartmentV2Dto> maplist = new ArrayList<>();

        for (Department department : departments) {
            maplist.add(convertToDto(department));
        }
        return maplist;
    }


    public Worker setEntityID(Worker worker) {
        worker.setDepartmentId(null);
        return worker;
    }

    public WorkerV2Dto setDtoId(WorkerV2Dto workerV2Dto) {
        workerV2Dto.setDepartment(null);
        return workerV2Dto;

    }

    public List<Worker> setListEntity(List<Worker> workers) {
        List<Worker> maplist = new ArrayList<>();
        for (Worker worker : workers) {
            worker.setDepartmentId(null);
            maplist.add(worker);
        }
        return maplist;
    }

    public List<WorkerV2Dto> setListDto(List<WorkerV2Dto> workerV2Dtos) {
        List<WorkerV2Dto> maplist = new ArrayList<>();

        for (WorkerV2Dto workerV2Dto : workerV2Dtos) {
            workerV2Dto.setDepartment(null);
            maplist.add(workerV2Dto);
        }
        return maplist;
    }


    public DepartmentV2Dto converToDtoToDepartment1(Department department) {

        ProjectDtoMapper projectDtoMapper = new ProjectDtoMapper();

        return DepartmentV2Dto.builder()
                .id(department.getId())
                .block(department.getBlock())
                .departmentname(department.getName())
                .salary(department.getSalary())
                .section(department.getSection())
                /*.project(projectDtoMapper.convertToDtoToProject(department.getProject()))*/
                .build();
    }

    //DTO TO ENTİTY
    public Department convertToEntityToDepartment(DepartmentV2Dto departmentV2Dto) {

        ProjectDtoMapper projectDtoMapper = new ProjectDtoMapper();
        return Department.builder()
                .id(departmentV2Dto.getId())
                .name(departmentV2Dto.getDepartmentname())
                .block(departmentV2Dto.getBlock())
                .salary(departmentV2Dto.getSalary())
                .section(departmentV2Dto.getSection())
                .project(projectDtoMapper.convertToEntityToProject(departmentV2Dto.getProject()))
                .build();

    }

    public DepartmentV2Dto converToDtoToDepartmentProject(Department department) {

        WorkerDtoMapper workerDtoMapper = new WorkerDtoMapper();
        ProjectDtoMapper projectDtoMapper = new ProjectDtoMapper();
        return DepartmentV2Dto.builder()
                .id(department.getId())
                .block(department.getBlock())
                .departmentname(department.getName())
                .salary(department.getSalary())
                .section(department.getSection())
                .work(workerDtoMapper.mapList(department.getWork()))
                .project(projectDtoMapper.convertToDtoToProject(department.getProject()))
                .build();
    }

    public List<DepartmentV2Dto> mapList(List<Department> departments) {
        List<DepartmentV2Dto> maplist = new ArrayList<>();
        for (Department work : departments) {
            maplist.add(converToDtoToDepartmentProject(work));
        }
        return maplist;

    }

    public List<Department> mapListToEntity(List<DepartmentV2Dto> departmentV2Dtos) {

        List<Department> departments = new ArrayList<>();

        for (DepartmentV2Dto departmentV2Dto : departmentV2Dtos) {
            departments.add(convertToEntityToDepartment(departmentV2Dto));
        }
        return departments;
    }

}
