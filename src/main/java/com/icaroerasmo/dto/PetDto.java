package com.icaroerasmo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icaroerasmo.entity.Pet;
import lombok.*;

import java.math.BigDecimal;
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
        @JsonFormat(pattern = "%.6f")
        private Double latitude;
        @JsonFormat(pattern = "%.6f")
        private Double longitude;
    }
}
