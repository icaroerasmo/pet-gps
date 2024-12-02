package com.icaroerasmo.controller;

import com.icaroerasmo.dto.Dto;
import com.icaroerasmo.entity.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface Controller<T extends AbstractEntity, R extends Dto<T>> {
    @PostMapping
    R save(@RequestBody R r);

    @PutMapping("/{id}")
    R update(@PathVariable UUID id, @RequestBody R r);

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id);

    @GetMapping("/{id}")
    R get(@PathVariable UUID id);

    @GetMapping
    Page<R> list(@RequestParam MultiValueMap<String, String> queryParams, Pageable pageable);
}
