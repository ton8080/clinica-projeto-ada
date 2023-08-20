package br.com.clinica.dto;

import br.com.clinica.entity.PacienteEntity;

public record PacienteListDto(
		Long id,
		 String nome,
		 String email,
		 String cpf,
		 String telefone
	    ) {
	public PacienteListDto(PacienteEntity pacienteEntity) {
		this(pacienteEntity.getId(), pacienteEntity.getNome(), pacienteEntity.getEmail(), pacienteEntity.getCpf(),
				pacienteEntity.getTelefone());
	}
}
