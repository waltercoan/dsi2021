package br.univille.walterdsi2021.api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
