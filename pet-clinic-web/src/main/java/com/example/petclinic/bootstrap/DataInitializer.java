package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import com.example.petclinic.services.map.OwnerServiceMap;
import com.example.petclinic.services.map.VetServiceMap;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Name");
        owner1.setLastName("Lastname");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("NameTwo");
        owner2.setLastName("LastnameTwo");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("VetName");
        vet1.setLastName("VetLastName");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("VetNameTwo");
        vet2.setLastName("VetLastNameTwo");

        vetService.save(vet2);

        System.out.println("DataLoaded...");

    }
}
