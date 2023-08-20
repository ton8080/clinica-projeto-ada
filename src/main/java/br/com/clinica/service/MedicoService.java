package br.com.clinica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.clinica.dto.DetalhesMedicoDto;
import br.com.clinica.dto.MedicoAtualizarDto;
import br.com.clinica.entity.MedicoEntity;

public interface MedicoService {
	public void cadastrar(MedicoEntity medicoEntity);
	public Page<MedicoEntity> listar(Pageable paginacao); 
	public DetalhesMedicoDto atualizar(MedicoAtualizarDto medico);
	public void deletar(int id);
	public DetalhesMedicoDto detalhar(Integer id);
}
