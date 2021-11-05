package br.univille.walterdsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.walterdsi2021.model.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel,Long>{
    Papel findByDescricao(String descricao);
}
