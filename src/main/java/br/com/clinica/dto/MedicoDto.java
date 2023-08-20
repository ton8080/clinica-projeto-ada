package br.com.clinica.dto;

import br.com.clinica.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDto(
		@NotBlank
		String nome, 
		@NotBlank
		@Email
		String email,
		@Pattern(regexp="\\d{11}")
		String telefone,
		@NotBlank
		//expresão regular
		//d indica digito e {4, 6} no minimo 4 digitos e no maximo 6
		@Pattern(regexp="\\d{4,6}")
	    String crm, 
		@NotNull
		Especialidade especialidade, 
		@NotNull
		@Valid //indica que o dto em questão tambem deve ser validado
		//o que deve ser validado está especificado dentro dele com as anotações
		EnderecoDto endereco
		) {

}
