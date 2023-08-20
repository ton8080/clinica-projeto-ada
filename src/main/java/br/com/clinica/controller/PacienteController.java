package br.com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.dto.PacienteAtualizar;
import br.com.clinica.dto.PacienteDto;
import br.com.clinica.dto.PacienteListDto;
import br.com.clinica.entity.PacienteEntity;
import br.com.clinica.service.PacienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping
	@Transactional
	public void cadatrar(@RequestBody @Valid PacienteDto paciente) {
		pacienteService.cadastrar(new PacienteEntity(paciente));
	}
	
	@GetMapping
	public ResponseEntity<Page<PacienteListDto>> listar(Pageable paginacao){
		Page<PacienteListDto> response = pacienteService.listar(paginacao).map(PacienteListDto::new);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> atualizar(@RequestBody @Valid PacienteAtualizar paciente) {
		var response = pacienteService.atualizar(paciente);
		return ResponseEntity.ok(response);
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		pacienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detalhar(@PathVariable Long id) {
		var paciente = pacienteService.detalhar(id);
		return ResponseEntity.ok(paciente);
	}
	
}
