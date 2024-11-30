package com.icaroerasmo.mapper;

import com.icaroerasmo.dto.Dto;
import org.springframework.data.domain.Page;

public interface GenericMapper<T, R extends Dto<T>> {

    R map(T t);

    T map(R dto);

    default Page<R> map(Page<T> page) {
        return page.map(this::map);
    }
}
