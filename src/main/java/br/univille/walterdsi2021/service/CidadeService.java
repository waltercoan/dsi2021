package br.univille.walterdsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.walterdsi2021.model.Cidade;

@Service
public interface CidadeService {
    public List<Cidade> getAll();
    public void save(Cidade cidade);
    public void delete(Cidade cidade);
}
