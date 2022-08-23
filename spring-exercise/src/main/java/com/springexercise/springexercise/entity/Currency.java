package com.springexercise.springexercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "currency")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "fiyat")
    private Double fiyat;

    @Column(name = "adet")
    private Long adet;

    @Column(name = "eski_fiyat")
    private Double eskiFiyat;

    @Column(name = "Durum")
    private Boolean durum;

}