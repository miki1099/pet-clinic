package com.example.petclinic.services.JpaServices;

import com.example.petclinic.model.Specialty;
import com.example.petclinic.repositories.SpecialtyRepository;
import com.example.petclinic.services.SpecialtiesService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Profile("JPAService")
public class VetSpecialtyServiceImpl implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;


    @Override
    public Set<Specialty> findAll() {

        Set<Specialty> specialties = new HashSet<>();

        specialtyRepository.findAll().forEach(specialties::add);

        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
