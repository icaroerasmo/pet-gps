package com.icaroerasmo.service;

import com.icaroerasmo.dto.Dto;
import com.icaroerasmo.entity.AbstractEntity;
import com.icaroerasmo.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

public class AbstractService<T extends AbstractEntity, R extends Dto<T>> extends AbstractSpecificationService<T> {

    @Autowired
    private JpaRepository<T, UUID> repository;

    @Autowired
    private JpaSpecificationExecutor<T> jpaSpecificationExecutor;

    @Autowired
    private GenericMapper<T, R> genericMapper;

    public R save(R dto) {

        if(dto == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }

        T entity = (T) genericMapper.map(dto);

        return genericMapper.map(repository.save(entity));
    }

    public R update(R dto) {

        if(dto == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }

        T entity = genericMapper.map(dto);

        if(entity.getId() == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        return genericMapper.map(repository.save(entity));
    }

    public void delete(UUID id) {
        if(id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        repository.deleteById(id);
    }

    public Page<R> list(
            MultiValueMap<String, String> queryParams,
            @PageableDefault(direction = Sort.Direction.DESC, sort = "createdAt") Pageable pageable
    ) {
        return (Page<R>) genericMapper.map(jpaSpecificationExecutor.findAll(getSpecification(queryParams), pageable));
    }
}
