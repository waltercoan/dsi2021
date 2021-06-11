package br.univille.walterdsi2021.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//MVC Model / View / Controller
@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping()
    public ModelAndView index(){

        HashMap<String,String> listaDeParzinho = new HashMap<>();
        listaDeParzinho.put("nome", "Sistema de DSI 2021 - NAO ACREDITO");
        listaDeParzinho.put("nomeEmpresa", "UNIVILLE SISTEMAS");

        

        return new ModelAndView("home/index", listaDeParzinho);
    }

}
