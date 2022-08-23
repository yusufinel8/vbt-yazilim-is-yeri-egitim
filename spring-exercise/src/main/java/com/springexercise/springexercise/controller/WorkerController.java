package com.springexercise.springexercise.controller;

import com.springexercise.springexercise.dto.builder.DepartmentV2Dto;
import com.springexercise.springexercise.dto.builder.ProjectV2Dto;
import com.springexercise.springexercise.dto.builder.WorkerV2Dto;
import com.springexercise.springexercise.mapper.DepartmentDtoMapper;
import com.springexercise.springexercise.mapper.ProjectDtoMapper;
import com.springexercise.springexercise.mapper.WorkerDtoMapper;
import com.springexercise.springexercise.repository.DeparmentRepo;
import com.springexercise.springexercise.repository.ProjectRepo;
import com.springexercise.springexercise.repository.UserRepo;
import com.springexercise.springexercise.repository.WorkerRepo;
import com.springexercise.springexercise.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerservice;
    private final WorkerRepo workerRepo;
    private final DeparmentRepo deparmentRepo;
    private final UserRepo users;
    private final DepartmentDtoMapper departmentDtoMapper;
    private final ProjectRepo projectRepo;
    private final ProjectDtoMapper projectDtoMapper;
    private final WorkerDtoMapper workerDtoMapper;

    @Autowired
    public WorkerController(DepartmentDtoMapper departmentDtoMapper,
                            WorkerService workerservice,
                            WorkerRepo workerRepo,
                            DeparmentRepo deparmentRepo,
                            UserRepo users,
                            ProjectRepo projectRepo,
                            ProjectDtoMapper projectDtoMapper,
                            WorkerDtoMapper workerDtoMapper) {
        this.workerservice = workerservice;
        this.workerRepo = workerRepo;
        this.deparmentRepo = deparmentRepo;
        this.users = users;
        this.departmentDtoMapper = departmentDtoMapper;
        this.projectRepo = projectRepo;
        this.projectDtoMapper = projectDtoMapper;
        this.workerDtoMapper = workerDtoMapper;
    }


    /*  @GetMapping(value = "/getWorker/{age}")
      public List<WorkerV2Dto> getAllAge(@PathVariable("age") Long age,Pageable pageable) {
          return workerservice.findAllAge(age,pageable);
      }
  */
    @GetMapping(value = "/getDepart")
    public List<DepartmentV2Dto> getDep() {
        List<DepartmentV2Dto> all = departmentDtoMapper.mapListToDto(deparmentRepo.findAll());

        return all;
    }

    @GetMapping(value = "/getWorker")
    public List<WorkerV2Dto> getWorker() {
        return workerservice.getWorker();
    }

    @GetMapping(value = "getProje")
    public List<ProjectV2Dto> getPro() {

        List<ProjectV2Dto> projectV2Dtos = projectDtoMapper.mapList(projectRepo.findAll());


        return projectV2Dtos;
    }




/*
    @PostMapping(value = "/saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WorkerV2Dto save(@RequestBody WorkerV2Dto workerV2Dto) {
        return workerservice.save(workerV2Dto);
    }
*/

    @PostMapping(value = "filter",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String filtreController(Model model, @RequestBody WorkerV2Dto workerDto, Pageable pageable) {
        List<WorkerV2Dto> workerDtos = workerservice.filterService(workerDto, pageable);
        model.addAttribute("users", workerDtos);
        return "User";
    }


}
