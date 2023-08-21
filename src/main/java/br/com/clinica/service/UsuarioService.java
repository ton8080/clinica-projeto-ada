package br.com.clinica.service;

import java.nio.file.AccessDeniedException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.clinica.dto.UsuarioAtualizarDto;
import br.com.clinica.dto.UsuarioBuscaDto;
import br.com.clinica.dto.UsuarioCadastroDto;
import br.com.clinica.dto.UsuarioDto;

public interface UsuarioService {
	void cadastrar(UsuarioCadastroDto usuarioDto);

	Page<UsuarioDto> listar(Pageable paginacao, String usuarioLogadoLogin) throws AccessDeniedException;

	void atualizarSenha(Long id, UsuarioAtualizarDto usuarioDto) throws AccessDeniedException;

	void deletar(Long id, String usuarioLogadoLogin) throws AccessDeniedException;
}
