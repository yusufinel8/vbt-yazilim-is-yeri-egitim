package com.springexercise.springexercise.repository;

import com.springexercise.springexercise.entity.Worker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Repository*/
public interface WorkerRepo extends JpaRepository<Worker, Long>, CrudRepository<Worker, Long>, PagingAndSortingRepository<Worker, Long>, JpaSpecificationExecutor<Worker> {

    void deleteById(Long id);

    @EntityGraph(attributePaths = {"departmentId"})
    List<Worker> findAll();


    List<Worker> findByAgeEquals(Long age, Pageable pageable);

    List<Worker> findByAgeLessThanEqual(Long age, Pageable pageable);


}

