package br.univille.walterdsi2021.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdsi2021.model.Consulta;
import br.univille.walterdsi2021.model.Paciente;
import br.univille.walterdsi2021.service.ConsultaService;
import br.univille.walterdsi2021.service.PacienteService;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService service; 
    @Autowired
    private PacienteService pacienteService;
    
    @GetMapping
    public ModelAndView index(){
        List<Consulta> listaConsultas = service.getAll();
        return new ModelAndView("consulta/index", "listaConsultas", listaConsultas);    
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Consulta consulta){
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("consulta", consulta);
        List<Paciente> listaPacientes = pacienteService.getAll();
        dados.put("listaPacientes", listaPacientes);
        return new ModelAndView("consulta/form",dados);
    }

    @PostMapping(params="form")
    public ModelAndView save(Consulta consulta){
        service.save(consulta);
        return new ModelAndView("redirect:/consulta");
    }

}
