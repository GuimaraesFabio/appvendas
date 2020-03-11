package com.dto;

import com.domain.Categoria;

public class CategoriaDto {

	private Integer id;
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
