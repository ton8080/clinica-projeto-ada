package br.com.clinica.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.clinica.entity.MedicoEntity;

class MedicoRepositoryTest {

	@Mock
	private MedicoRepository medicoRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAllByAtivoTrue() {
		// Criação dos objetos de teste
		MedicoEntity medico1 = new MedicoEntity();
		MedicoEntity medico2 = new MedicoEntity();
		List<MedicoEntity> medicoList = Arrays.asList(medico1, medico2);
		Page<MedicoEntity> medicoPage = new PageImpl<>(medicoList);

		// Configuração do comportamento simulado do repositório
		Pageable pageable = Pageable.ofSize(10).withPage(0);
		when(medicoRepository.findAllByAtivoTrue(pageable)).thenReturn(medicoPage);

		// Execução do método a ser testado
		Page<MedicoEntity> result = medicoRepository.findAllByAtivoTrue(pageable);

		// Verificação do resultado
		assertEquals(medicoPage, result);
		verify(medicoRepository, times(1)).findAllByAtivoTrue(pageable);
	}
}
