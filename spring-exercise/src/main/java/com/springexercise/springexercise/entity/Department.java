package com.springexercise.springexercise.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedEntityGraph(name = "Department.id", attributeNodes = @NamedAttributeNode("id"))
public class Department implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "block")
    private String block;

    @Column(name = "salary")
    private String salary;

    @Column(name = "section")
    private String section;

    @JsonIgnore
    @OneToMany(mappedBy = "departmentId", fetch = FetchType.LAZY)
    private List<Worker> work;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


}