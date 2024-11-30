package com.icaroerasmo.mapper;

import com.icaroerasmo.dto.PetLocalizationDto;
import com.icaroerasmo.entity.PetLocalization;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PetLocalizationMapper extends GenericMapper<PetLocalization, PetLocalizationDto> {
    @Override
    @Mapping(target = "petId", source = "pet.id")
    PetLocalizationDto map(PetLocalization petLocalization);

    @Override
    @Mapping(target = "pet.id", source = "petId")
    PetLocalization map(PetLocalizationDto dto);
}
