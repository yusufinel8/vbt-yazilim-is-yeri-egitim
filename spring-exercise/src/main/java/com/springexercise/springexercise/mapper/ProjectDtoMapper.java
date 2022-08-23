package com.springexercise.springexercise.mapper;

import com.springexercise.springexercise.dto.builder.ProjectV2Dto;
import com.springexercise.springexercise.entity.Project;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectDtoMapper {

    public ProjectV2Dto convertToDtoToProject(Project project) {

        DepartmentDtoMapper departmentDtoMapper = new DepartmentDtoMapper();

        return ProjectV2Dto.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .build();
    }

    public Project convertToEntityToProject(ProjectV2Dto projectV2Dto) {

        DepartmentDtoMapper departmentDtoMapper = new DepartmentDtoMapper();

        return Project.builder()
                .id(projectV2Dto.getId())
                .projectName(projectV2Dto.getProjectName())
                /*.departments(departmentDtoMapper.mapListToEntity(projectV2Dto.getDepartmentV2Dto()))*/
                .build();
    }


    public List<ProjectV2Dto> mapList(List<Project> projectList) {
        List<ProjectV2Dto> maplist = new ArrayList<>();


        for (Project project : projectList) {
            maplist.add(convertToDtoToProject(project));
        }
        return maplist;
    }
}
