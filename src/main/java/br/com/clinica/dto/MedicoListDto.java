package br.com.clinica.dto;

import br.com.clinica.entity.MedicoEntity;
import br.com.clinica.enums.Especialidade;

public record MedicoListDto(
		Long id,
		 String nome,
		 String email,
		 String crm,
		 String telefone,
	    Especialidade especialidade
	    ) {
	public MedicoListDto(MedicoEntity medicoEntity) {
		this(medicoEntity.getId(),medicoEntity.getNome(), medicoEntity.getEmail(), medicoEntity.getCrm(),
				medicoEntity.getTelefone(),medicoEntity.getEspecialidade());
	}
}
