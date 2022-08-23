package com.springexercise.springexercise.spec;

import com.springexercise.springexercise.entity.Worker;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class WorkerSpec implements Specification<Worker> {

    private Worker filtre;


    public WorkerSpec(Worker filter) {
        super();
        this.filtre = filter;
    }

    @Override
    public Predicate toPredicate(Root<Worker> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.disjunction();
        return p;
    }

    public static Specification<Worker> findByFilter(Worker filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate p = criteriaBuilder.disjunction();
            List<Predicate> predicateList = new ArrayList<>();

            if (filter != null) {
                if (filter.getId() != null) {
                    predicateList.add(criteriaBuilder.greaterThan(root.get("id"), filter.getId()));
                }
                if (filter.getFirstName() != null) {
                    //predicateList.add(criteriaBuilder.equal(root.get("firstname"), filter.getFirstname()));
                    predicateList.add(criteriaBuilder.equal(root.get("firstName"),filter.getFirstName()));
                }
                if (filter.getLastName() != null) {
                    predicateList.add(criteriaBuilder.greaterThan(root.get("lastname"), filter.getLastName()));
                }
                if (filter.getAge() != null) {
                    predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("age"), filter.getAge() + 15));
                }
                if (filter.getDepartmentId() != null) {
                    predicateList.add(criteriaBuilder.notEqual(root.get("departmentId"), filter.getDepartmentId()));
                }

            }
            p.getExpressions().add(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
            query.distinct(true);

            return p;
        };
    }
}











     /*  if(filter.getAge()!=null){
                     predicateList.add(CriteriaQuery)
                }*/

                /* gelen id ye göre büyükleri getiren kod

                  if (filter.getId() != null) {
                    predicateList.add(criteriaBuilder.greaterThan(root.get("id"), filter.getId()));
                }

                 gelen id ye göre küçükleri getiren kod
                *   if (filter.getId() != null) {
                    predicateList.add(criteriaBuilder.lessThan(root.get("id"), filter.getId()));
                }
                * */