package com.icaroerasmo.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.icaroerasmo.util.ClassUtil.containsProperty;

public abstract class AbstractSpecificationService<T> {
    protected Specification<T> getSpecification(MultiValueMap<String, String> queryParams) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            filterByParams(queryParams, cb, root, predicates);
            return cb.and(predicates.toArray(new Predicate[]{}));
        };
    }

    private void filterByParams(
            MultiValueMap<String, String> queryParams, CriteriaBuilder cb,
            Root<T> root, List<Predicate> predicates) {
        final Set<String> keys = queryParams.keySet();

        final List<String> ignore = Arrays.asList(
          "createdAt", "updatedAt", "createdAtBeginning",
          "createdAtEnd", "updatedAtBeginning","updatedAtEnd"
        );

        keys.stream().filter((param -> containsProperty(root.getModel().getBindableJavaType(), param, ignore))).
                forEach(param -> {
                    CriteriaBuilder.In<String> inClause = cb.in(root.get(param));
                    queryParams.get(param).forEach(inClause::value);
                    predicates.add(inClause);
                });
        if(keys.contains("createdAtBeginning")) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), queryParams.get("createdAtBeginning").getFirst()));
        }
        if(keys.contains("createdAtEnd")) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), queryParams.get("createdAtEnd").getFirst()));
        }
        if(keys.contains("updatedAtBeginning")) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("updatedAt"), queryParams.get("updatedAtBeginning").getFirst()));
        }
        if(keys.contains("updatedAtEnd")) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("updatedAt"), queryParams.get("updatedAtEnd").getFirst()));
        }
    }
}
