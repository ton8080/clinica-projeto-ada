package br.com.clinica.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.clinica.dto.DetalhesMedicoDto;
import br.com.clinica.dto.MedicoAtualizarDto;
import br.com.clinica.dto.MedicoDto;
import br.com.clinica.dto.MedicoListDto;
import br.com.clinica.entity.MedicoEntity;
import br.com.clinica.service.impl.MedicoServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoServiceImpl medicoService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid MedicoDto medicoDto, UriComponentsBuilder uriComponent) {
		MedicoEntity medicoEntity = new MedicoEntity(medicoDto);
		medicoService.cadastrar(medicoEntity);
		URI uri = uriComponent.path("/medicos/{id}").buildAndExpand(medicoEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalhesMedicoDto(medicoEntity));
	}

	@GetMapping
	public ResponseEntity<Page<MedicoListDto>> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
		var response = medicoService.listar(paginacao).map(MedicoListDto::new);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> atualizar(@RequestBody @Valid MedicoAtualizarDto medico) {
		var response = medicoService.atualizar(medico);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		medicoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detalhar(@PathVariable Integer id) {
		var response = medicoService.detalhar(id);
		return ResponseEntity.ok(response);
	}
}
