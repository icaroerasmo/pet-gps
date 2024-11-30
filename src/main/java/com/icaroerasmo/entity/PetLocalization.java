package com.icaroerasmo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PetLocalization extends AbstractEntity {

    @ManyToOne
    private Pet pet;

    @Column
    private long latitude;

    @Column
    private long longitude;
}
