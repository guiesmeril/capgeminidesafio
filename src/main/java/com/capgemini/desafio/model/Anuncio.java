package com.capgemini.desafio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnuncio;
	private String nomeAnuncio;
	private Date dataInicio;
	private Date dataFim;
	private Double investimento;
	private String nomeCliente;

	public Anuncio() {

	}


	public Long getIdAnuncio() {
		return idAnuncio;
	}



	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}



	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
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

	public Double getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Double investimento) {
		this.investimento = investimento;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@Override
	public String toString() {
		return "Anuncio [idAnuncio=" + idAnuncio + ", nomeAnuncio=" + nomeAnuncio + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", investimento=" + investimento + ", nomeCliente=" + nomeCliente + "]";
	}

}
