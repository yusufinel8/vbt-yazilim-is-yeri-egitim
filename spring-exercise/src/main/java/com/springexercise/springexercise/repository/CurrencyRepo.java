package com.springexercise.springexercise.repository;

import com.springexercise.springexercise.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo  extends JpaRepository<Currency,Long>, CrudRepository<Currency,Long> {


}
