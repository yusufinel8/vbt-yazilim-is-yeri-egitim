package com.springexercise.springexercise.dto.builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springexercise.springexercise.enumm.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerV2Dto implements Serializable {
    @JsonIgnore
    private Long id;
    @NotNull(value = "Firstname alanı boş bırakılamaz")
    private String firstname;
    @NotNull(value = "lastname alanı boş bırakılamaz")
    private String lastname;
    @NotNull(value = "age alanı boş bırakılamaz")
    private Long age;
    @NotNull(value = "Gender alanı boş bırakılamaz")
    private Gender gender;

    private DepartmentV2Dto department;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


}



