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
    public ModelAndView getConsulta(
            @RequestParam(name = "searchType", required = false) String searchType,
            @RequestParam(name = "pokemonValue", required = false) String pokemonValue,
            @RequestParam(name = "elementDesc", required = false) String elementDesc) {
        ModelAndView mv = new ModelAndView("consulta.html");
        try {
            if ("name".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonByName(pokemonValue));
            } else if ("hp".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsByHp(Integer.parseInt(pokemonValue)));
            } else if ("total".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsByTotal(Integer.parseInt(pokemonValue)));
            } else if ("attack".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsByAttack(Integer.parseInt(pokemonValue)));
            } else if ("defense".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsByDefense(Integer.parseInt(pokemonValue)));
            } else if ("speed".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsBySpeed(Integer.parseInt(pokemonValue)));
            } else if ("speedAttack".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsBySpeedAttack(Integer.parseInt(pokemonValue)));
            } else if ("speedDefense".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsBySpeedDefense(Integer.parseInt(pokemonValue)));
            } else if ("generation".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsByGeneration(Integer.parseInt(pokemonValue)));
            } else if ("legendary".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonsByLegendary(pokemonValue));
            }
        } catch (NumberFormatException e) {
            mv.addObject("invalidInput", true);
        }

        if (elementDesc != null && !elementDesc.isEmpty()) {
            mv.addObject("pokemonsByElement", pokemonBC.getDetailedPokemonsByElement(elementDesc));
        }

        mv.addObject("selectedType", elementDesc);
        mv.addObject("searchType", searchType);
        mv.addObject("types", elementBC.getElements());
        mv.addObject("pokemons", pokemonBC.getDetailedPokemons());

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