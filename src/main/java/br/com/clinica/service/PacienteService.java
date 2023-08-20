package br.com.clinica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.clinica.dto.DadosDetalhePaciente;
import br.com.clinica.dto.PacienteAtualizar;
import br.com.clinica.entity.PacienteEntity;

public interface PacienteService {
	public void cadastrar(PacienteEntity paciente);
	public Page<PacienteEntity> listar(Pageable paginacao);
	public DadosDetalhePaciente atualizar(PacienteAtualizar paciente);
	public void deletar(Long id);
	public DadosDetalhePaciente detalhar(Long id);

}
