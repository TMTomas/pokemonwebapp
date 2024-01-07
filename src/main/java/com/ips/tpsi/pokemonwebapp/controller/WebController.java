package com.ips.tpsi.pokemonwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
            if ("id".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults", pokemonBC.getDetailedPokemonById(Integer.parseInt(pokemonValue)));
            } else if ("name".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
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
                mv.addObject("pokemonResults",
                        pokemonBC.getDetailedPokemonsBySpeedAttack(Integer.parseInt(pokemonValue)));
            } else if ("speedDefense".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults",
                        pokemonBC.getDetailedPokemonsBySpeedDefense(Integer.parseInt(pokemonValue)));
            } else if ("generation".equals(searchType) && pokemonValue != null && !pokemonValue.isEmpty()) {
                mv.addObject("pokemonResults",
                        pokemonBC.getDetailedPokemonsByGeneration(Integer.parseInt(pokemonValue)));
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

    @PostMapping("/alterar")
    public ModelAndView postAlterar(
            @RequestParam(name = "pokemonId") int pokemonId,
            @RequestParam(name = "attribute") String attribute,
            @RequestParam(name = "newValue") String newValue) {
        ModelAndView mv = new ModelAndView("alterar.html");
        try {
            switch (attribute) {
                case "pokemonName":
                    pokemonBC.updatePokemonName(pokemonId, newValue);
                    break;
                case "total":
                    pokemonBC.updatePokemonTotal(pokemonId, Integer.parseInt(newValue));
                    break;
                case "hp":
                    pokemonBC.updatePokemonHp(pokemonId, Integer.parseInt(newValue));
                    break;
                case "attack":
                    pokemonBC.updatePokemonAttack(pokemonId, Integer.parseInt(newValue));
                    break;
                case "defense":
                    pokemonBC.updatePokemonDefense(pokemonId, Integer.parseInt(newValue));
                    break;
                case "speed":
                    pokemonBC.updatePokemonSpeed(pokemonId, Integer.parseInt(newValue));
                    break;
                case "speedAttack":
                    pokemonBC.updatePokemonSpeedAttack(pokemonId, Integer.parseInt(newValue));
                    break;
                case "speedDefense":
                    pokemonBC.updatePokemonSpeedDefense(pokemonId, Integer.parseInt(newValue));
                    break;
                case "generation":
                    pokemonBC.updatePokemonGeneration(pokemonId, Integer.parseInt(newValue));
                    break;
                case "legendary":
                    if ("true".equalsIgnoreCase(newValue) || "false".equalsIgnoreCase(newValue)) {
                        pokemonBC.updatePokemonLegendary(pokemonId, newValue);
                    } else {
                        mv.addObject("errorMessage", "O valor para o campo 'Legendary' deve ser 'true' ou 'false'.");
                    }
                    break;
                case "element1":
                    if (!elementBC.isElementExists(newValue)) {
                        mv.addObject("errorMessage",
                                "O elemento '" + newValue + "' não existe. Por favor, insira um elemento válido.");
                    } else {
                        pokemonBC.updatePokemonElement1(pokemonId, newValue);
                    }
                    break;
                case "element2":
                    if (!elementBC.isElementExists(newValue)) {
                        mv.addObject("errorMessage",
                                "O elemento '" + newValue + "' não existe. Por favor, insira um elemento válido.");
                    } else {
                        pokemonBC.updatePokemonElement2(pokemonId, newValue);
                    }
                    break;
                default:
                    mv.addObject("errorMessage", "Tipo de alteração não suportado.");
                    break;
            }
            mv.addObject("successMessage", "Pokémon(s) alterados(s) com sucesso.");
            mv.addObject("pokemonId", pokemonId);
        } catch (NumberFormatException e) {
            mv.addObject("errorMessage",
                    "Erro ao converter o critério para alteração. Certifique-se de inserir um valor válido.");
        }
        
        mv.addObject("attribute", attribute);
        mv.addObject("newValue", newValue);
        mv.addObject("pokemons", pokemonBC.getDetailedPokemons());

        return mv;
    }

    @GetMapping("/apagar")
    public ModelAndView getApagar() {
        ModelAndView mv = new ModelAndView("apagar.html");
        return mv;
    }

    @PostMapping("/apagar")
    public ModelAndView postApagar(
            @RequestParam(name = "deleteType") String deleteType,
            @RequestParam(name = "pokemonCriteria") String pokemonCriteria) {
        ModelAndView mv = new ModelAndView("apagar.html");
        try {
            switch (deleteType) {
                case "id":
                    pokemonBC.deletePokemonById(Integer.parseInt(pokemonCriteria));
                    break;
                case "name":
                    pokemonBC.deletePokemonByName(pokemonCriteria);
                    break;
                case "element":
                    pokemonBC.deletePokemonByElement(pokemonCriteria);
                    break;
                case "total":
                    pokemonBC.deletePokemonByTotal(Integer.parseInt(pokemonCriteria));
                    break;
                case "hp":
                    pokemonBC.deletePokemonByHp(Integer.parseInt(pokemonCriteria));
                    break;
                case "attack":
                    pokemonBC.deletePokemonByAttack(Integer.parseInt(pokemonCriteria));
                    break;
                case "defense":
                    pokemonBC.deletePokemonByDefense(Integer.parseInt(pokemonCriteria));
                    break;
                case "speed":
                    pokemonBC.deletePokemonBySpeed(Integer.parseInt(pokemonCriteria));
                    break;
                case "speedAttack":
                    pokemonBC.deletePokemonBySpeedAttack(Integer.parseInt(pokemonCriteria));
                    break;
                case "speedDefense":
                    pokemonBC.deletePokemonBySpeedDefense(Integer.parseInt(pokemonCriteria));
                    break;
                case "generation":
                    pokemonBC.deletePokemonByGeneration(Integer.parseInt(pokemonCriteria));
                    break;
                case "legendary":
                    pokemonBC.deletePokemonByLegendary(pokemonCriteria);
                    break;
                default:
                    mv.addObject("errorMessage", "Tipo de exclusão não suportado.");
                    break;
            }
            mv.addObject("successMessage", "Pokémon(s) apagados(s) com sucesso.");
        } catch (NumberFormatException e) {
            mv.addObject("errorMessage",
                    "Erro ao converter o critério para exclusão. Certifique-se de inserir um valor válido.");
        }
        mv.addObject("deleteType", deleteType);
        mv.addObject("pokemonCriteria", pokemonCriteria);
        mv.addObject("pokemons", pokemonBC.getDetailedPokemons());
        return mv;
    }
}