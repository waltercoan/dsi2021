package br.univille.walterdsi2021.api;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.walterdsi2021.model.Paciente;
import br.univille.walterdsi2021.service.PacienteService;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteControllerAPI {
    
    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> getAll(){
        List<Paciente> listaPaciente = service.getAll();
        return new ResponseEntity<List<Paciente>>(listaPaciente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Paciente> insert(@RequestBody Paciente paciente){
        try{
            paciente.setId(0);
            service.save(paciente);
            return new ResponseEntity<Paciente>(paciente, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Paciente>> insertList(@RequestBody List<Paciente> listaPacientes){
        for(Paciente umPaciente: listaPacientes){
            umPaciente.setId(0);
            service.save(umPaciente);
        }
        return new ResponseEntity<List<Paciente>>(listaPacientes,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") Paciente paciente){
        return new ResponseEntity<Paciente>(paciente,HttpStatus.OK);
    }

}
