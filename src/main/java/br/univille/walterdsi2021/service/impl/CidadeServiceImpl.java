package br.univille.walterdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.walterdsi2021.model.Cidade;
import br.univille.walterdsi2021.repository.CidadeRepository;
import br.univille.walterdsi2021.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{

    @Autowired
    private CidadeRepository repository;

    @Override
    public List<Cidade> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Cidade cidade) {
        repository.save(cidade);
    }

    @Override
    public void delete(Cidade cidade) {
        repository.delete(cidade);
    }
    
}
