package com.paulo.pessoas.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class PessoaDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private String id;
	@NotBlank(message = "Nome não pode ser nulo")
	private String nome;
	@NotNull(message = "Idade não pode ser nulo")
	@Min(value = 0, message = "Idade não pode ser menor que 0")
	private Integer idade;

	public PessoaDTO(String id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public PessoaDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}
}
