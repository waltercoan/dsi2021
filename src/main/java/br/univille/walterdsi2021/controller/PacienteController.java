package br.univille.walterdsi2021.controller;
import java.util.HashMap;
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
import br.univille.walterdsi2021.model.Paciente;
import br.univille.walterdsi2021.service.CidadeService;
import br.univille.walterdsi2021.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @Autowired
    private CidadeService cidadeService;
    
    @GetMapping
    public ModelAndView index(){
        List<Paciente> listaPacientes = service.getAll();
        return new ModelAndView("paciente/index", "listaPacientes", listaPacientes);    
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Paciente paciente){
        HashMap<String,Object> dados = new HashMap<>();
        List<Cidade> listaCidades = cidadeService.getAll();
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("paciente/form",dados);
    }
    @PostMapping(params="form")
    public ModelAndView save(Paciente paciente){
        service.save(paciente);
        return new ModelAndView("redirect:/paciente");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Paciente paciente){
        HashMap<String,Object> dados = new HashMap<>();
        List<Cidade> listaCidades = cidadeService.getAll();
        dados.put("listaCidades", listaCidades);
        dados.put("paciente",paciente);
        return new ModelAndView("paciente/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Paciente paciente){
        service.delete(paciente);
        return new ModelAndView("redirect:/paciente");
    }

}
