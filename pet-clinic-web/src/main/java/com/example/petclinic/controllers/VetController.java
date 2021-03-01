package com.example.petclinic.controllers;

import com.example.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
@AllArgsConstructor
public class VetController {

    private final VetService vetService;

    @RequestMapping({"", "/", "/index"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
