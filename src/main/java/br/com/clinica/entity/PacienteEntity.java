package br.com.clinica.entity;

import br.com.clinica.dto.EnderecoDto;
import br.com.clinica.dto.PacienteAtualizar;
import br.com.clinica.dto.PacienteDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "Pacientes")
public class PacienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@Embedded
	private EnderecoDto endereco;
	private Boolean ativo;

	public PacienteEntity(PacienteDto pacienteDto) {
		this.ativo = true;
		this.nome = pacienteDto.nome();
		this.email = pacienteDto.email();
		this.endereco = new EnderecoDto(pacienteDto);
		this.telefone = pacienteDto.telefone();
		this.cpf = pacienteDto.cpf();
	}

	public void atualizarInformacao(PacienteAtualizar paciente) {
		if (paciente.nome() != null) {
			this.nome = paciente.nome();
		}
		if (paciente.telefone() != null) {
			this.telefone = paciente.telefone();
		}
		if (paciente.endereco() != null) {
			this.endereco.atualizarInformacoes(paciente.endereco());
		}
	}

	public void excluir() {
		this.ativo = false;
	}

}
