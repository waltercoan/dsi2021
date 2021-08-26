package br.univille.walterdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.walterdsi2021.model.Consulta;
import br.univille.walterdsi2021.repository.ConsultaRepository;
import br.univille.walterdsi2021.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public List<Consulta> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Consulta consulta) {
        repository.save(consulta);
    }

    @Override
    public void delete(Consulta consulta) {
        repository.delete(consulta);
    }
    
}
