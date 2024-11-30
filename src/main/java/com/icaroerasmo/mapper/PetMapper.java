package com.icaroerasmo.mapper;

import com.icaroerasmo.dto.Dto;
import com.icaroerasmo.dto.PetDto;
import com.icaroerasmo.entity.Pet;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PetMapper extends GenericMapper<Pet, PetDto> {
    @Override
    PetDto map(Pet pet);

    @Override
    Pet map(PetDto dto);
}
