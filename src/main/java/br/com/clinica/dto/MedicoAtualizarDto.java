package br.com.clinica.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoAtualizarDto(
		@NotNull
		Integer id,
		String nome, 
		@Pattern(regexp="\\d{11}")
		String telefone,
		EnderecoDto endereco
		) {

}
