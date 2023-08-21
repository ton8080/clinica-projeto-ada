package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.clinica.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UserDetails findByLogin(String login);

	@Query(value = "SELECT * FROM Usuarios WHERE login = :login", nativeQuery = true)
	UsuarioEntity findByUserLogin(String login);

	boolean existsByLogin(String login);
}