package com.springexercise.springexercise.dto.Worker;

import com.springexercise.springexercise.entity.Department;
import com.springexercise.springexercise.enumm.Gender;
import com.springexercise.springexercise.entity.Worker;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Setter
@Getter
public class WorkerDto implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private Long age;
    private Department department;
    private Gender gender;

    public WorkerDto() {

    }

    public WorkerDto(Builder builder) {
        this.id = builder.id;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.age = builder.age;
        this.department = builder.department;
        this.gender=builder.gender;
    }


    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public static class Builder {
        private Long id;
        private String firstname;
        private String lastname;
        private Long age;
        private Department department;
        private Gender gender;
        public Builder() {
        }

        public static Builder workerWith() {
            return new Builder();
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder gender(final Gender gender) {
            this.gender= gender;
            return this;
        }

        public Builder firstname(final String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(final String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder age(final Long age) {
            this.age = age;
            return this;
        }

        public Builder department(final Department department) {
            this.department = department;
            return this;
        }

        public WorkerDto build() {
            return new WorkerDto(this);
        }


        public Worker converToEntity(WorkerDto workerDto) {

            return Worker.builder()
                    .lastName(workerDto.getLastname())
                    .firstName(workerDto.getFirstname())
                    .age(workerDto.getAge())
                    .departmentId(workerDto.getDepartment())
                    .id(workerDto.getId())
                    .gender(workerDto.gender)
                    .build();

        }

        public Worker converToEntityBuilder(WorkerDto workerDto) {

            Worker worker = new Worker();
            worker.setId(workerDto.getId());
            worker.setFirstName(workerDto.getFirstname());
            worker.setLastName(workerDto.getLastname());
            worker.setAge(workerDto.getAge());
            worker.setDepartmentId(workerDto.getDepartment());
            worker.setGender(workerDto.gender);
            return worker;
        }

    }
}
