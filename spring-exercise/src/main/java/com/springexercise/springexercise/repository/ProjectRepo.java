package com.springexercise.springexercise.repository;

import com.springexercise.springexercise.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> , CrudRepository<Project,Long> {
}

