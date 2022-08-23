package com.springexercise.springexercise.dto.Worker;

import com.springexercise.springexercise.entity.Department;
import com.springexercise.springexercise.entity.Worker;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class DepartmentDto implements Serializable {

    private Long id;
    private String departmentname;
    private String block;
    private String salary;
    private String section;
    private List<Worker> workers;
    public DepartmentDto(Builder builder) {
        this.id = builder.id;
        this.departmentname = builder.departmentname;
        this.block =builder.block;
        this.salary = builder.salary;
        this.section = builder.section;
        this.workers=builder.workers;

    }

    public DepartmentDto() {
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
        private String departmentname;
        private String block;
        private String salary;
        private String section;
        private List<Worker> workers;
        public Builder() {

        }

        public static Builder departmentWith() {
            return new Builder();
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder worker(final List<Worker> workers) {
            this.workers = workers;
            return this;
        }


        public Builder departmentname(final String departmentname) {
            this.departmentname = departmentname;
            return this;
        }

        public Builder block(final String block) {
            this.block = block;
            return this;
        }

        public Builder salary(final String salary) {
            this.salary = salary;
            return this;
        }

        public Builder section(final String section) {
            this.section = section;
            return this;
        }



        public DepartmentDto build() {
            return new DepartmentDto(this);
        }

        public Department convertToEntity(DepartmentDto departmentDto) {
            Department department = new Department();
            department.setId(departmentDto.getId());
            department.setName(departmentDto.getDepartmentname());
            department.setBlock(departmentDto.getBlock());
            department.setSalary(departmentDto.getSalary());
            department.setSection(departmentDto.getSection());
            /*department.setWork(departmentDto.getWorkers());*/
            return department;
        }

    }
}
