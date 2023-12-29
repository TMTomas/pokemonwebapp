package com.ips.tpsi.pokemonwebapp.controller;

import com.ips.tpsi.pokemonwebapp.bc.ElementService;
import com.ips.tpsi.pokemonwebapp.bc.PokemonService;
import com.ips.tpsi.pokemonwebapp.entity.Element;
import com.ips.tpsi.pokemonwebapp.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ElementController {

    @Autowired
    ElementService elementBC;

    public ElementController(ElementService elementBC) {
        this.elementBC = elementBC;
    }

    @GetMapping("/consulta/elements")
    public ModelAndView getElements() {
        ModelAndView mv = new ModelAndView("consulta.html");
        mv.addObject("elements", elementBC.getElements());
        return mv;
    }

    @GetMapping("/consulta/elements/{idElement}")
    public ModelAndView getPokemon(@PathVariable("idElement") Integer idElement){
        ModelAndView mv = new ModelAndView("consulta.html");
        mv.addObject("pokemon", elementBC.getElement(idElement));
        return mv;
    }

    @GetMapping("/consulta/elements/{elementName}")
    public ModelAndView getPokemon(@PathVariable("elementName") String elementName){
        ModelAndView mv = new ModelAndView("consulta.html");
        mv.addObject("pokemon", elementBC.getElement(elementName));
        return mv;
    }

    @PostMapping("/consulta/elements/create")
    public Element createElement(@RequestBody Element element){
        return elementBC.saveElement(element);
    }

    @DeleteMapping("consulta/elements/{idElement}")
    public void deletePokemon(@PathVariable("element") Integer idElement) {
        elementBC.deleteElement(idElement);
    }
}
