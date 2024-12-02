package com.icaroerasmo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PetLocalization extends AbstractEntity {

    @JoinColumn(name = "petId")
    @ManyToOne(optional = false)
    private Pet pet;

    @Column
    private Double latitude;

    @Column
    private Double longitude;
}
