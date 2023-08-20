package br.com.clinica.dto;

import br.com.clinica.entity.PacienteEntity;

public record DadosDetalhePaciente(
		Long id,
		String nome,
		String email,
	    String telefone,
		String cpf,
		EnderecoDto endereco
		) {

	public DadosDetalhePaciente(PacienteEntity entity) {
	this(entity.getId(), entity.getNome(), entity.getEmail(), entity.getTelefone(), 
			entity.getCpf(), entity.getEndereco());
		
	}
}
