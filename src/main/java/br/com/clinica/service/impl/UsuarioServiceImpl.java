package br.com.clinica.service.impl;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.clinica.dto.UsuarioAtualizarDto;
import br.com.clinica.dto.UsuarioCadastroDto;
import br.com.clinica.dto.UsuarioDto;
import br.com.clinica.entity.UsuarioEntity;
import br.com.clinica.repository.UsuarioRepository;
import br.com.clinica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void cadastrar(UsuarioCadastroDto usuarioDto) {
		if (usuarioRepository.existsByLogin(usuarioDto.login())) {
			throw new RuntimeException("Login já existe. Escolha outro login.");
		}

		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setLogin(usuarioDto.login());
		usuario.setSenha(passwordEncoder.encode(usuarioDto.senha()));
		usuarioRepository.save(usuario);
	}

	@Override
	public void atualizarSenha(Long id, UsuarioAtualizarDto usuarioDto) throws AccessDeniedException {
		
		if (!usuarioDto.codigoSeguranca().equals("x")) {
			throw new AccessDeniedException("Codigo de segurança inválido");
		}

		UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		String novaSenha = usuarioDto.senha();

		String senhaHash = passwordEncoder.encode(novaSenha);

		usuarioEntity.setSenha(senhaHash);
		usuarioRepository.save(usuarioEntity);
	}

	@Override
	public void deletar(Long id, String usuarioLogadoLogin) throws AccessDeniedException {
		UsuarioEntity usuarioLogado = usuarioRepository.findByUserLogin(usuarioLogadoLogin);
		UsuarioEntity usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		
        if (usuarioLogado == null || !usuarioLogado.getLogin().equals("admin@email.com")) {
            throw new AccessDeniedException("Apenas o administrador pode deletar os usuários.");
        }
        
        if (usuario.getLogin().equals(usuarioLogado.getLogin())&& usuario.getId().equals(usuarioLogado.getId())) {
        	throw new AccessDeniedException("Não é possivel excluir o Adm.");
		}

		usuarioRepository.delete(usuarioLogado);
	}

    @Override
    public Page<UsuarioDto> listar(Pageable paginacao, String usuarioLogadoLogin) throws AccessDeniedException {
        UsuarioEntity usuarioLogado = usuarioRepository.findByUserLogin(usuarioLogadoLogin);
        
        if (usuarioLogado == null || !usuarioLogado.getLogin().equals("admin@email.com")) {
            throw new AccessDeniedException("Apenas o administrador pode listar os usuários.");
        }
        
        Page<UsuarioEntity> usuariosPage = usuarioRepository.findAll(paginacao);
        return usuariosPage.map(UsuarioDto::new);
    }

}