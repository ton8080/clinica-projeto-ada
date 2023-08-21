package br.com.clinica.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.dto.UsuarioAtualizarDto;
import br.com.clinica.dto.UsuarioCadastroDto;
import br.com.clinica.dto.UsuarioDto;
import br.com.clinica.entity.UsuarioEntity;
import br.com.clinica.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioCadastroDto usuarioDto) {
		usuarioService.cadastrar(usuarioDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_USER') and @securityConfigurations.isAdmin(authentication)")
	public ResponseEntity<Page<UsuarioDto>> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao,
			@AuthenticationPrincipal UsuarioEntity usuarioAutenticado) throws AccessDeniedException {
		var response = usuarioService.listar(paginacao, usuarioAutenticado.getLogin());
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarSenhaUsuario(@PathVariable Long id,
			@RequestBody @Valid UsuarioAtualizarDto usuarioDto) throws AccessDeniedException {
		usuarioService.atualizarSenha(id, usuarioDto);
		return ResponseEntity.ok().body("Senha alterada com sucesso");
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER') and @securityConfigurations.isAdmin(authentication)")
	public ResponseEntity<?> deletarUsuario(@PathVariable Long id, @AuthenticationPrincipal UsuarioEntity usuarioAutenticado) throws AccessDeniedException {
		usuarioService.deletar(id, usuarioAutenticado.getLogin());
		return ResponseEntity.noContent().build();
	}
}
