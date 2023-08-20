package br.com.clinica.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteAtualizar(
		@NotNull
		Long id,
		String nome,
		@Pattern(regexp = "\\d{11}")
		String telefone,
		EnderecoDto endereco) {

}
