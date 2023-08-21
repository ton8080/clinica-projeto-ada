package br.com.clinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCadastroDto(@NotBlank @Email String login, @NotBlank String senha) {

}
