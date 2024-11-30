package com.icaroerasmo.controller;

import com.icaroerasmo.dto.Dto;
import com.icaroerasmo.entity.AbstractEntity;
import com.icaroerasmo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

public class AbstractController<T extends AbstractEntity, R extends Dto<T>> implements Controller<T, R> {

    @Autowired
    private AbstractService<T, R> service;

    @Override
    public R save(R r) {
        return service.save(r);
    }

    @Override
    public R update(Long id, R r) {
        return service.update(r);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public Page<R> list(MultiValueMap<String, String> queryParams, Pageable pageable) {
        return service.list(queryParams, pageable);
    }
}
