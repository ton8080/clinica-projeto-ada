package br.com.clinica.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.entity.MedicoEntity;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {

	Page<MedicoEntity> findAllByAtivoTrue(Pageable paginacao);

}
