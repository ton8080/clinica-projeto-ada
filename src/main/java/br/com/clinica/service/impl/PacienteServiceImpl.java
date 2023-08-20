package br.com.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clinica.dto.DadosDetalhePaciente;
import br.com.clinica.dto.PacienteAtualizar;
import br.com.clinica.entity.PacienteEntity;
import br.com.clinica.repository.PacienteRepository;
import br.com.clinica.service.PacienteService;
import jakarta.transaction.Transactional;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	@Override
	@Transactional
	public void cadastrar(PacienteEntity paciente) {
		pacienteRepository.save(paciente);
	}


	@Override
	public Page<PacienteEntity> listar(Pageable paginacao) {
		return pacienteRepository.findAllByAtivoTrue(paginacao);
	}


	@Override
	@Transactional
	public DadosDetalhePaciente atualizar(PacienteAtualizar paciente) {
		var pacienteReference = pacienteRepository.getReferenceById(paciente.id());
		pacienteReference.atualizarInformacao(paciente);
		return new DadosDetalhePaciente(pacienteReference);
	}


	@Override
	public void deletar(Long id) {
		var pacienteReference = pacienteRepository.getReferenceById(id);
		pacienteReference.excluir();
	}


	@Override
	public DadosDetalhePaciente detalhar(Long id) {
		var pacienteReference = pacienteRepository.getReferenceById(id);
		return new DadosDetalhePaciente(pacienteReference);
	}
	
	

	
}
