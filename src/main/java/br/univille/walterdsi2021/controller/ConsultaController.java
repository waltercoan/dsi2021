package br.univille.walterdsi2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdsi2021.model.Consulta;
import br.univille.walterdsi2021.service.ConsultaService;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService service; 
    
    @GetMapping
    public ModelAndView index(){
        List<Consulta> listaConsultas = service.getAll();
        return new ModelAndView("consulta/index", "listaConsultas", listaConsultas);    
    }

}
