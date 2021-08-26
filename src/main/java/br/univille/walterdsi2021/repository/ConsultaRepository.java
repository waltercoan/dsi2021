package br.univille.walterdsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.walterdsi2021.model.Consulta;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long>{
    
}
