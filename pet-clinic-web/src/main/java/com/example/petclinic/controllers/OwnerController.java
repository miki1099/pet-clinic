package com.example.petclinic.controllers;

import com.example.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
@AllArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @RequestMapping({"", "/", "/index"})
    public String listOwners(Model model){
            model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

}