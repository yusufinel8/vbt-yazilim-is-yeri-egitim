package com.springexercise.springexercise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Department> departments;


}
