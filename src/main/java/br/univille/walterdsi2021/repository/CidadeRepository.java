package br.univille.walterdsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.walterdsi2021.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long>{
    
}
