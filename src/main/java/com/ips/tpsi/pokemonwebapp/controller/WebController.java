package com.ips.tpsi.pokemonwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ips.tpsi.pokemonwebapp.bc.ElementService;
import com.ips.tpsi.pokemonwebapp.bc.PokemonService;

@Controller
public class WebController {

    @Autowired
    PokemonService pokemonBC;

    @Autowired
    ElementService elementBC;

    public WebController(PokemonService pokemonBC, ElementService elementBC) {
        this.pokemonBC = pokemonBC;
        this.elementBC = elementBC;
    }

    @GetMapping("/index")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }

    @GetMapping("/sobre-nos")
    public ModelAndView getSobreNos() {
        ModelAndView mv = new ModelAndView("sobreNos.html");
        return mv;
    }

    @GetMapping("/consulta")
    public ModelAndView getConsulta(@RequestParam(name = "pokemonName", required = false) String pokemonName,
            @RequestParam(name = "elementDesc", required = false) String elementDesc) {
        ModelAndView mv = new ModelAndView("consulta.html");

        if (pokemonName != null && !pokemonName.isEmpty()) {
            mv.addObject("pokemonByName", pokemonBC.getDetailedPokemonByName(pokemonName));
        }

        if (elementDesc != null && !elementDesc.isEmpty()) {
            mv.addObject("pokemonsByElement", pokemonBC.getDetailedPokemonsByElement(elementDesc));
        }

        mv.addObject("selectedType", elementDesc);
        mv.addObject("pokemons", pokemonBC.getDetailedPokemons());
        mv.addObject("types", elementBC.getElements());

        return mv;
    }

    @GetMapping("/alterar")
    public ModelAndView getAlterar() {
        ModelAndView mv = new ModelAndView("alterar.html");
        return mv;
    }

    @GetMapping("/apagar")
    public ModelAndView getApagar() {
        ModelAndView mv = new ModelAndView("apagar.html");
        return mv;
    }
}