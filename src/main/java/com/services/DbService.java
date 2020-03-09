package com.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Categoria;
import com.domain.Produto;
import com.repositories.CategoriaRepository;
import com.repositories.ProdutoRepository;

@Service
public class DbService {

	@Autowired
	private CategoriaRepository _categoriaRepository;
	@Autowired
	private ProdutoRepository _produtoRepository;

	public void instanciateTestDataBase() {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		_categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
	
		cat1.getProdutos().addAll(Arrays.asList(p1, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

	
		_produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

	}
}
