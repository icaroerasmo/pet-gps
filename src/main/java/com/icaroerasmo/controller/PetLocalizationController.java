package com.icaroerasmo.controller;

import com.icaroerasmo.dto.PetDto;
import com.icaroerasmo.dto.PetLocalizationDto;
import com.icaroerasmo.entity.PetLocalization;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localization")
public class PetLocalizationController extends AbstractController<PetLocalization, PetLocalizationDto> {
}
