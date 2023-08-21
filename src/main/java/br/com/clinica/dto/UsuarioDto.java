package br.com.clinica.dto;

import org.springframework.data.domain.Page;

import br.com.clinica.entity.UsuarioEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
		
		Long id, 
		@NotBlank
		@Email
		String login, 
		@NotBlank
		String senha) {

	public UsuarioDto(UsuarioEntity usuarioEntity) {
		this(usuarioEntity.getId(), usuarioEntity.getLogin(), usuarioEntity.getSenha());
	}

}
