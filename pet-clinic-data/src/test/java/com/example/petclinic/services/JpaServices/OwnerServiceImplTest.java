package com.example.petclinic.services.JpaServices;

import com.example.petclinic.model.Owner;
import com.example.petclinic.repositories.OwnerRepository;
import com.example.petclinic.repositories.PetRepository;
import com.example.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    public static final String LASTNAME = "Lastname";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceImpl service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setLastName(LASTNAME);
        returnOwner.setId(1L);
    }

    @Test
    void findByLastName() {

        when(service.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = ownerRepository.findByLastName(LASTNAME);

        assertEquals(LASTNAME, owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Owner returnOwner3 = new Owner();
        returnOwner3.setId(3L);
        returnOwner3.setAddress("Gd1");

        Owner returnOwner2 = new Owner();
        returnOwner2.setId(2L);
        returnOwner2.setAddress("GY2");

        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(returnOwner);
        returnOwnersSet.add(returnOwner2);
        returnOwnersSet.add(returnOwner3);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);

        assertEquals(3, owners.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);

    }

    @Test
    void findByIdButNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(10L);

        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner owner = service.save(returnOwner);

        assertNotNull(owner);

    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteByID() {
        service.deleteByID(1L);

        verify(ownerRepository, times(1)).deleteById(1L);
    }
}