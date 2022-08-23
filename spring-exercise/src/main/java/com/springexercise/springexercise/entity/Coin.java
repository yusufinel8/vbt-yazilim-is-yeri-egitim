package com.springexercise.springexercise.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "ethbtc")
public class Coin implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "price")
    private String price;

    @Column(name = "qty")
    private String qty;

    @Column(name = "quoteQty")
    private String quoteQty;

    @Column(name = "isBuyerMaker")
    private Boolean isBuyerMaker;



}



