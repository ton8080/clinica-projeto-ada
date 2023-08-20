package br.com.clinica.dto;

import br.com.clinica.entity.MedicoEntity;
import br.com.clinica.enums.Especialidade;

public record DetalhesMedicoDto(
	    Long id,
		String nome,
		String email,
		String crm,
		String telefone,
		Especialidade especialidade,
		EnderecoDto endereco
		) {
	
	public DetalhesMedicoDto(MedicoEntity entity) {
		this(entity.getId(), entity.getNome(), entity.getEmail(), entity.getCrm(),
				entity.getTelefone(), entity.getEspecialidade(), entity.getEndereco());
	}
	
}
