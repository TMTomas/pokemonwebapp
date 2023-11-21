package com.ips.tpsi.pokemonwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/yourMapping")
    public String yourMethod() {
        // Your logic here
        return "index";
    }
}