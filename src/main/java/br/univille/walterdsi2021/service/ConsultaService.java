package br.univille.walterdsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.walterdsi2021.model.Consulta;

@Service
public interface ConsultaService {
    public List<Consulta> getAll();
    public void save(Consulta consulta);
    public void delete(Consulta consulta);
}
