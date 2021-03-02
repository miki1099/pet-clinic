package com.example.petclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet extends BaseEntity{

    private String name;
    private PetType petType;
    private LocalDate birthDate;
}
