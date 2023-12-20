package com.ips.tpsi.pokemonwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
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
    public ModelAndView getConsulta() {
        ModelAndView mv = new ModelAndView("consulta.html");
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