package br.univille.walterdsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.walterdsi2021.model.Paciente;

@Service
public interface PacienteService {
    public List<Paciente> getAll();
}
