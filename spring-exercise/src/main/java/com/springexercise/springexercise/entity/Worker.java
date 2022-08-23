package com.springexercise.springexercise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springexercise.springexercise.enumm.Gender;
import lombok.*;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.io.Serializable;


@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worker")
public class Worker implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Long age;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department departmentId;

}
