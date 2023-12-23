package com.ips.tpsi.pokemonwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ips.tpsi.pokemonwebapp.bc.PokemonService;
import com.ips.tpsi.pokemonwebapp.entity.Pokemon;

@Controller
public class WebController {

     @Autowired
    PokemonService bc;

    public WebController(PokemonService bc) {
        this.bc = bc;
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
    public ModelAndView getConsulta(@RequestParam(name = "pokemonName", required = false) String pokemonName) {
        ModelAndView mv = new ModelAndView("consulta.html");

        if (pokemonName != null && !pokemonName.isEmpty()) {
            Object pokemon = bc.getPokemonInfoByName(pokemonName);
            mv.addObject("searchResult", pokemon);
        }

        mv.addObject("pokemons", bc.getPokemonsWithTypes());
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