package com.example.petclinic.repositories;

import com.example.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PetTypeRepository extends CrudRepository<PetType, Long> {

    Optional<PetType> findFirstByName(String Name);

}
