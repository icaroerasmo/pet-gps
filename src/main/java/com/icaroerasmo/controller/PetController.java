package com.icaroerasmo.controller;

import com.icaroerasmo.dto.PetDto;
import com.icaroerasmo.entity.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController extends AbstractController<Pet, PetDto> {
}
