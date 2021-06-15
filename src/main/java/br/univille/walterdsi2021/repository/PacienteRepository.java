package br.univille.walterdsi2021.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.walterdsi2021.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    List<Paciente> findByNomeContains(String nome);
}
