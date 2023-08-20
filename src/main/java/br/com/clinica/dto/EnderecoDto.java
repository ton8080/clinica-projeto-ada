package br.com.clinica.dto;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDto {
	@NotBlank
	String logradouro;
	@NotBlank
	String bairro;
	@NotBlank
	@Pattern(regexp="\\d{8}")
	String cep;
	@NotBlank
	String cidade;
	@NotBlank
	String uf;
	String numero;
	String complemento;
	
	public EnderecoDto(MedicoDto medicoDto) {
		this.logradouro = medicoDto.endereco().logradouro;
		this.bairro = medicoDto.endereco().bairro;
		this.cep = medicoDto.endereco().cep;
		this.cidade = medicoDto.endereco().cidade;
		this.uf = medicoDto.endereco().uf;
		this.numero = medicoDto.endereco().numero;
		this.complemento = medicoDto.endereco().complemento;
	}
	
	public EnderecoDto(PacienteDto pacienteDto) {
		this.logradouro = pacienteDto.endereco().logradouro;
		this.bairro = pacienteDto.endereco().bairro;
		this.cep = pacienteDto.endereco().cep;
		this.cidade = pacienteDto.endereco().cidade;
		this.uf = pacienteDto.endereco().uf;
		this.numero = pacienteDto.endereco().numero;
		this.complemento = pacienteDto.endereco().complemento;
	}

	public EnderecoDto(MedicoAtualizarDto medicoDto) {
		this.atualizarInformacoes(medicoDto.endereco());
	}
	
	public EnderecoDto(PacienteAtualizar paciente) {
		this.atualizarInformacoes(paciente.endereco());
	}

	public void atualizarInformacoes(EnderecoDto endereco) {
		if(endereco.bairro != null) {
			this.bairro = endereco.bairro;
		}
		if(endereco.logradouro != null) {
			this.logradouro = endereco.logradouro;
		}
		if(endereco.cep != null) {
			this.cep = endereco.cep;
		}
		if(endereco.cidade != null) {
			this.cidade = endereco.cidade;
		}
		if(endereco.uf != null) {
			this.uf = endereco.uf;
		}
		if(endereco.numero != null) {
			this.numero = endereco.numero;
		}
		if(endereco.complemento != null) {
			this.complemento = endereco.complemento;
		}
	}
}
