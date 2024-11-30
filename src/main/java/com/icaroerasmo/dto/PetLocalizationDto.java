package com.icaroerasmo.dto;

import com.icaroerasmo.entity.PetLocalization;
import lombok.*;

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
    private long latitude;
    private long longitude;
}
