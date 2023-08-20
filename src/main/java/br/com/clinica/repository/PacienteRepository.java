package br.com.clinica.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.entity.PacienteEntity;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

	Page<PacienteEntity> findAllByAtivoTrue(Pageable paginacao);

}
