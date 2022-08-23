package com.springexercise.springexercise.dto.builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.springexercise.springexercise.entity.Project;
import com.springexercise.springexercise.mapper.DepartmentDtoMapper;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIncludeProperties("projectName")
public class ProjectV2Dto implements Serializable {

    @JsonIgnore
    private Long id;
    @NotNull(value = "Project Name alanı boş bırakılamaz")
    private String projectName;
    private List<DepartmentV2Dto> departmentV2Dto;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }




}
