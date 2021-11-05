package br.univille.walterdsi2021.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.walterdsi2021.model.Papel;
import br.univille.walterdsi2021.repository.PapelRepository;
import br.univille.walterdsi2021.service.PapelService;

@Service
public class PapelServiceImpl implements PapelService {
    
    @Autowired
    private PapelRepository repository;
    
    @Override
    public Papel findByDescricao(String descricao) {
        return repository.findByDescricao(descricao);
    }

    @Override
    public void save(Papel papel) {
       repository.save(papel);
    }
    
}
