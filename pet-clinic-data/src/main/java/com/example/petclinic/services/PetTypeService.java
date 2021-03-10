package com.example.petclinic.services;

import com.example.petclinic.model.PetType;

import java.util.Optional;

public interface PetTypeService extends CrudService<PetType, Long>{

    Optional<PetType> findFirstByName(String name);
}
