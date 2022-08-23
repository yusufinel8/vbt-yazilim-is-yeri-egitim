package com.springexercise.springexercise.dto.builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentV2Dto implements Serializable {
    @JsonIgnore
    private Long id;
    @NotNull(message = "departmentname alanı boş bırakılamaz")
    private String departmentname;
    @NotNull(message = "block alanı boş bırakılamaz")
    private String block;
    @NotNull(message = "salary alanı boş bırakılamaz")
    private String salary;
    @NotNull(message = "section alanı boş bırakılamaz")
    private String section;

    private List<WorkerV2Dto> work;

    @NotNull(message = "Project alanı boş bırakılamaz")
    private ProjectV2Dto project;


    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


}

