package com.icaroerasmo.repository;

import com.icaroerasmo.entity.PetLocalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PetLocalizationRepository extends JpaRepository<PetLocalization, UUID>, JpaSpecificationExecutor<PetLocalization> {
}
