package com.capgemini.desafio.model;

import java.util.Date;

public class Relatorio {

	private String nomeCliente;
	private String nomeAnuncio;
	private Long idAnuncio;
	private Double valorTotalInvestido;
	private int quantidadeMaximaVisualizacoes;
	private int quantidadeMaximaCliques;
	private int quantidadeMaximaCompartilhamentos;
	private Date dataInicio;
	private Date dataFim;

	public Relatorio() {

	}

	public Double getValorTotalInvestido() {
		return valorTotalInvestido;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeAnuncio() {
		return nomeAnuncio;
	}
	

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public void setValorTotalInvestido(Double valorTotalInvestido) {
		this.valorTotalInvestido = valorTotalInvestido;
	}

	public int getQuantidadeMaximaVisualizacoes() {
		return quantidadeMaximaVisualizacoes;
	}

	public void setQuantidadeMaximaVisualizacoes(int quantidadeMaximaVisualizacoes) {
		this.quantidadeMaximaVisualizacoes = quantidadeMaximaVisualizacoes;
	}

	public int getQuantidadeMaximaCliques() {
		return quantidadeMaximaCliques;
	}

	public void setQuantidadeMaximaCliques(int quantidadeMaximaCliques) {
		this.quantidadeMaximaCliques = quantidadeMaximaCliques;
	}

	public int getQuantidadeMaximaCompartilhamentos() {
		return quantidadeMaximaCompartilhamentos;
	}

	public void setQuantidadeMaximaCompartilhamentos(int quantidadeMaximaCompartilhamentos) {
		this.quantidadeMaximaCompartilhamentos = quantidadeMaximaCompartilhamentos;
	}

	@Override
	public String toString() {
		return "Relatorio [nomeCliente=" + nomeCliente + ", nomeAnuncio=" + nomeAnuncio + ", idAnuncio=" + idAnuncio
				+ ", valorTotalInvestido=" + valorTotalInvestido + ", quantidadeMaximaVisualizacoes="
				+ quantidadeMaximaVisualizacoes + ", quantidadeMaximaCliques=" + quantidadeMaximaCliques
				+ ", quantidadeMaximaCompartilhamentos=" + quantidadeMaximaCompartilhamentos + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + "]";
	}



}
