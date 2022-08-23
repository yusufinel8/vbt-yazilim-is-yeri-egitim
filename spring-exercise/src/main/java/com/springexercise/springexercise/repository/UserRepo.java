package com.springexercise.springexercise.repository;

import com.springexercise.springexercise.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>, CrudRepository<Users, Long> {
}
