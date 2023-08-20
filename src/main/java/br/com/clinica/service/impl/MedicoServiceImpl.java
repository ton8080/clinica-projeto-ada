package br.com.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clinica.dto.DetalhesMedicoDto;
import br.com.clinica.dto.MedicoAtualizarDto;
import br.com.clinica.entity.MedicoEntity;
import br.com.clinica.repository.MedicoRepository;
import br.com.clinica.service.MedicoService;
import jakarta.transaction.Transactional;

@Service
public class MedicoServiceImpl implements MedicoService{
	
	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	@Transactional
	public void cadastrar(MedicoEntity medicoEntity) {
		medicoRepository.save(medicoEntity);
	}

	@Override
	public Page<MedicoEntity> listar(Pageable paginacao) {
		return medicoRepository.findAllByAtivoTrue(paginacao);
	}

	@Override
	@Transactional
	public DetalhesMedicoDto atualizar(MedicoAtualizarDto medico) {
		var medicoReference = medicoRepository.getReferenceById(medico.id());
		medicoReference.atualizarInformacao(medico);
		return new DetalhesMedicoDto(medicoReference);
	}

	@Override
	@Transactional
	public void deletar(int id) {
		var medicoReference = medicoRepository.getReferenceById(id);
		medicoReference.excluir();
	}

	@Override
	public DetalhesMedicoDto detalhar(Integer id) {
		var medicoReference = medicoRepository.getReferenceById(id);
		return new DetalhesMedicoDto(medicoReference);
	}

}
