package com.example.petclinic.formatters;

import com.example.petclinic.model.PetType;
import com.example.petclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Optional<PetType> type = petTypeService.findFirstByName(text);

//        for (PetType type : findPetTypes) {
//            if (type.getName().equals(text)) {
//                return type;
//            }
//        }
        if(type.isPresent()) {
            return type.get();
        } else {
            throw new ParseException("type not found: " + text, 0);
        }
    }


}
