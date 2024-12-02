package com.icaroerasmo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icaroerasmo.entity.PetLocalization;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PetLocalizationDto implements Dto<PetLocalization> {
    private UUID id;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private UUID petId;
    @JsonFormat(pattern = "%.6f")
    private Double latitude;
    @JsonFormat(pattern = "%.6f")
    private Double longitude;
}
