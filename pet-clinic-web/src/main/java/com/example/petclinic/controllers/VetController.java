package com.example.petclinic.controllers;

import com.example.petclinic.model.Vet;
import com.example.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RequestMapping("/vets")
@Controller
@AllArgsConstructor
public class VetController {

    private final VetService vetService;

    @RequestMapping({"", "/", "/index", ".html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @GetMapping("api/vets")
    public @ResponseBody Set<Vet> getJsonVets() {
        return vetService.findAll();
    }

}
