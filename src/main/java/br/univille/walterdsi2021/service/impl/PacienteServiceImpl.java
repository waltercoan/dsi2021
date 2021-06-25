package br.univille.walterdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.walterdsi2021.model.Paciente;
import br.univille.walterdsi2021.repository.PacienteRepository;
import br.univille.walterdsi2021.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository repository;
    
    @Override
    public List<Paciente> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Paciente paciente) {
        repository.save(paciente);
    }
    
}
