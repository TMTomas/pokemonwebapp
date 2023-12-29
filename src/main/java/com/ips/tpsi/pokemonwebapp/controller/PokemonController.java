package com.ips.tpsi.pokemonwebapp.controller;

import com.ips.tpsi.pokemonwebapp.bc.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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





//    @PostMapping("/pokemons/alter")
//    public ModelAndView createPokemon() {
//        ModelAndView mv = new ModelAndView("alterar.html");
//        mv.addObject("pokemonsAlter", pokemonBC.getDetailedPokemons());
//        return mv;
//    }
//    @PostMapping("/pokemons/alter")
//    public ModelAndView alterPokemon(@RequestParam(name = "idPokemon", required = true) Integer idPokemon){
//        ModelAndView mv = new ModelAndView("alterar.html");
//        mv.addObject("pokemonAlter", pokemonBC.alterDetailedPokemon(idPokemon, pokemonName, total, hp, attack, defense, speed, speedAttack, speedDefense, generation, legendary));
//        return mv;
//    }
//
//    @PostMapping("/pokemons/alter")
//    public ModelAndView alterPokemon(@RequestParam(name = "pokemonName", required = true) String pokemonName){
//        ModelAndView mv = new ModelAndView("alterar.html");
//        mv.addObject("pokemonAlter", pokemonBC.alterDetailedPokemon(idPokemon, pokemonName, total, hp, attack, defense, speed, speedAttack, speedDefense, generation, legendary));
//        return mv;
//    }
}
