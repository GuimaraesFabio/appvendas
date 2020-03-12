package com.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.domain.Categoria;

public class CategoriaDto {

	private Integer id;
	
	@NotEmpty(message = "Preencimento obrigatorio")
	@Length(min = 5,max = 80,message = "Campo nome deve conter entre 5 a 80 caracteres")
	private String nome;

	public CategoriaDto() {
	}

	public CategoriaDto(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
