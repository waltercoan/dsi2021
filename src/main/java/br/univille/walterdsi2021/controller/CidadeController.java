package br.univille.walterdsi2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdsi2021.model.Cidade;
import br.univille.walterdsi2021.service.CidadeService;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService service;
    
    @GetMapping
    public ModelAndView index(){
        List<Cidade> listaCidades = service.getAll();
        return new ModelAndView("cidade/index", "listaCidades", listaCidades);    
    }
}
