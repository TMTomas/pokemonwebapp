package com.ips.tpsi.pokemonwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("home.html");
        return mv;
    }

    @GetMapping("/name")
    public ModelAndView getName() {
        ModelAndView mv = new ModelAndView("index.html");

        mv.addObject("nome", "danilo");
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("home.html");
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("home.html");
        return mv;
    }
}
