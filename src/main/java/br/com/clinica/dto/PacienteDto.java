package br.com.clinica.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDto(
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		@NotBlank
		String telefone,
		@NotBlank
		//111.111.111-11
		@Pattern(regexp="\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
		String cpf, 
		@NotNull
		@Valid
		EnderecoDto endereco
) {

}
