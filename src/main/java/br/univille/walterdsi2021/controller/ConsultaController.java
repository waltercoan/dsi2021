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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdsi2021.model.Consulta;
import br.univille.walterdsi2021.model.Paciente;
import br.univille.walterdsi2021.model.ProcedimentoRealizado;
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
        ProcedimentoRealizado novoprocrealizado = new ProcedimentoRealizado();
        dados.put("novoprocrealizado", novoprocrealizado);
        return new ModelAndView("consulta/form",dados);
    }

    @PostMapping()
    public ModelAndView save(Consulta consulta){
        service.save(consulta);
        return new ModelAndView("redirect:/consulta");
    }

    @PostMapping(params= {"insertproc"})
    public ModelAndView insertproc(Consulta consulta, ProcedimentoRealizado novoprocrealizado) {
        List<Paciente> listaPacientes = pacienteService.getAll();
        consulta.getListaProcedimentos().add(novoprocrealizado);
   
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("consulta", consulta);
        dados.put("listaPacientes", listaPacientes);
        dados.put("novoprocrealizado", new ProcedimentoRealizado());
       
        return new ModelAndView("consulta/form",dados);
    }
   
    @PostMapping(params= {"removeproc"})
    public ModelAndView removeproc(@RequestParam(name = "removeproc") int index, Consulta consulta, ProcedimentoRealizado novoprocrealizado) {
        List<Paciente> listaPacientes = this.pacienteService.getAll();
       
        consulta.getListaProcedimentos().remove(index);
   
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("consulta", consulta);
        dados.put("listaPacientes", listaPacientes);
        dados.put("novoprocrealizado", new ProcedimentoRealizado());
       
        return new ModelAndView("consulta/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Consulta consulta){
        List<Paciente> listaPacientes = this.pacienteService.getAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("consulta", consulta);
        dados.put("listaPacientes", listaPacientes);
        dados.put("novoprocrealizado", new ProcedimentoRealizado());
        return new ModelAndView("consulta/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Consulta consulta){
        service.delete(consulta);
        return new ModelAndView("redirect:/consulta");
    }

}
