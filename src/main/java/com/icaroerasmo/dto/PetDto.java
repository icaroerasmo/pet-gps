package com.icaroerasmo.dto;

import com.icaroerasmo.entity.Pet;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PetDto implements Dto<Pet> {
    private UUID id;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String name;
    private LocalDate birthDate;
    private List<PetLocalization> localizationHistory;

    @Data
    public static class PetLocalization {
        private long latitude;
        private long longitude;
    }
}
