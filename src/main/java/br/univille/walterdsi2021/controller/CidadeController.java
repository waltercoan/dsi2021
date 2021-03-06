package br.univille.walterdsi2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Cidade cidade){
        return new ModelAndView("cidade/form");
    }
    @PostMapping(params="form")
    public ModelAndView save(Cidade cidade){
        service.save(cidade);
        return new ModelAndView("redirect:/cidade");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Cidade cidade){
        return new ModelAndView("/cidade/form","cidade",cidade);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Cidade cidade){
        service.delete(cidade);
        return new ModelAndView("redirect:/cidade");
    }
}
