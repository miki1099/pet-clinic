package com.example.petclinic.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Owner extends Person{

    private String  address;
    private String city;
    private String phone;
    private Set<Pet> pets = new HashSet<>();

}
