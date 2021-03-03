package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.SpecialtiesService;
import com.example.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Name");
        owner1.setLastName("Lastname");
        owner1.setAddress("street 15");
        owner1.setCity("Gdansk");
        owner1.setPhone("534-504-495");


        Pet pet = new Pet();
        pet.setPetType(savedDogPetType);
        pet.setOwner(owner1);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Pet Name");

        owner1.getPets().add(pet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("NameTwo");
        owner2.setLastName("LastnameTwo");
        owner1.setAddress("street 16");
        owner1.setCity("Wroclaw");
        owner1.setPhone("543-545-912");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Pet Name2");

        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty radiologySaved = specialtiesService.save(radiology);
        Specialty surgerySaved = specialtiesService.save(surgery);
        Specialty dentistrySaved = specialtiesService.save(dentistry);


        Vet vet1 = new Vet();
        vet1.setFirstName("VetName");
        vet1.setLastName("VetLastName");
        vet1.getSpecialties().add(radiologySaved);
        vet1.getSpecialties().add(surgerySaved);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("VetNameTwo");
        vet2.setLastName("VetLastNameTwo");
        vet1.getSpecialties().add(dentistrySaved);
        vetService.save(vet2);

        System.out.println("DataLoaded...");
    }

}
