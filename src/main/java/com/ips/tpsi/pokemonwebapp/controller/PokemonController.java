package com.ips.tpsi.pokemonwebapp.controller;

import com.ips.tpsi.pokemonwebapp.bc.PokemonService;
import com.ips.tpsi.pokemonwebapp.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PokemonController {

    @Autowired
    PokemonService pokemonBC;

    public PokemonController(PokemonService pokemonBC) {
        this.pokemonBC = pokemonBC;
    }

    @GetMapping("/consulta/pokemons")
    public ModelAndView getPokemons() {
        ModelAndView mv = new ModelAndView("consulta.html");
        mv.addObject("pokemons", pokemonBC.getDetailedPokemons());
        return mv;
    }

    @GetMapping("/consulta/pokemons/{idPokemon}")
    public ModelAndView getPokemon(@PathVariable("idPokemon") Integer idPokemon){
        ModelAndView mv = new ModelAndView("consulta.html");
        mv.addObject("pokemon", pokemonBC.getDetailedPokemon(idPokemon));
        return mv;
    }

    @GetMapping("/consulta/pokemons/{pokemonName}")
    public ModelAndView getPokemon(@PathVariable("pokemonName") String pokemonName){
        ModelAndView mv = new ModelAndView("consulta.html");
        mv.addObject("pokemon", pokemonBC.getDetailedPokemon(pokemonName));
        return mv;
    }

    @PostMapping("/consulta/pokemons/create")
    public Pokemon alterPokemon(@RequestBody Pokemon pokemon){
        return pokemonBC.savePokemon(pokemon);
    }


}
