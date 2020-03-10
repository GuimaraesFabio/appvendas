package com.domain;

import javax.persistence.Entity;

import com.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcela;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento descricao, Pedido pedido, Integer numeroDeParcela) {
		super(id, descricao, pedido);
		this.numeroDeParcela = numeroDeParcela;
	}

	public Integer getNumeroDeParcela() {
		return numeroDeParcela;
	}

	public void setNumeroDeParcela(Integer numeroDeParcela) {
		this.numeroDeParcela = numeroDeParcela;
	}

}
