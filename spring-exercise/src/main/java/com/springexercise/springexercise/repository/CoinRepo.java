package com.springexercise.springexercise.repository;

import com.springexercise.springexercise.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepo extends JpaRepository<Coin,Long> , CrudRepository<Coin,Long> {

}
