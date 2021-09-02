package br.univille.walterdsi2021.controller;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdsi2021.model.Cidade;
import br.univille.walterdsi2021.model.Paciente;
import br.univille.walterdsi2021.service.CidadeService;
import br.univille.walterdsi2021.service.PacienteService;
import br.univille.walterdsi2021.service.StorageFilesService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @Autowired
    private CidadeService cidadeService;
    
    @Autowired
    private StorageFilesService storageFilesService;

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
    public ModelAndView save(Paciente paciente, @RequestParam("file") MultipartFile file){
        if(file.getSize() != 0){
            String caminho = storageFilesService.save(file);
            paciente.setFoto(caminho);
        }
        service.save(paciente);
        return new ModelAndView("redirect:/paciente");
    }

    @GetMapping(value = "/image/{id}")
    public @ResponseBody byte[] getImage(@PathVariable("id") Paciente paciente){
        try{
            File file = new File(paciente.getFoto());
            byte[] bytes = new byte[(int) file.length()];
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            dis.readFully(bytes);
            return bytes;
        }catch (Exception e){
            return new byte[0];
        }
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
