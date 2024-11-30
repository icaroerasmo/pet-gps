package com.icaroerasmo.repository;

import com.icaroerasmo.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID>, JpaSpecificationExecutor<Pet> {
}
