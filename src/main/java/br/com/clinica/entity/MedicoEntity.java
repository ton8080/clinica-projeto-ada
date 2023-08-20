package br.com.clinica.entity;

import br.com.clinica.dto.EnderecoDto;
import br.com.clinica.dto.MedicoAtualizarDto;
import br.com.clinica.dto.MedicoDto;
import br.com.clinica.enums.Especialidade;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Medicos")
public class MedicoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String email;
	private String crm;
	private String telefone;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@Embedded
	private EnderecoDto endereco;
	private Boolean ativo; 

	public MedicoEntity(MedicoDto medicoDto) {
		this.ativo = true;
		this.nome = medicoDto.nome();
		this.email = medicoDto.email();
		this.crm = medicoDto.crm();
		this.especialidade = medicoDto.especialidade();
		this.endereco = new EnderecoDto(medicoDto);
		this.telefone = medicoDto.telefone();
	}

	public void atualizarInformacao(MedicoAtualizarDto medico) {
		if (medico.nome() != null) {
			this.nome = medico.nome();
		}
		if (medico.telefone() != null) {
			this.telefone = medico.telefone();
		}
		if (medico.endereco() != null) {
			this.endereco.atualizarInformacoes(medico.endereco());
		}
	}

	public void excluir() {
		this.ativo = false;
	}
}
