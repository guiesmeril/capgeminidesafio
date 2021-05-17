package com.capgemini.desafio.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.desafio.model.Anuncio;
import com.capgemini.desafio.repository.AnuncioRepository;
import com.capgemini.desafio.service.exceptions.*;

@Service
public class RegraNegocio {

	@Autowired
	private AnuncioRepository anuncioRepository;

	public void verificarAnuncioJaExiste(String name) {
		List<Anuncio> listAnuncio = new ArrayList<>();
		listAnuncio = anuncioRepository.findNomeAnuncio(name);
		
		if (!listAnuncio.isEmpty()) {
			throw new ExcecaoAnuncioJaExiste("Já existe um anuncio cadastrado com esse nome, Favor tentar novamente!!");
		}
	}

	public int calcularMaximaVisualizacao(Date dataInicio, Date dataFim, double investimentoDia) {
		int vizualizacoes = (int) (calcularValorInvestimento(dataInicio, dataFim, investimentoDia) * 30);
		int quantidadeCliques = calcularQuantidadeCliques(vizualizacoes);
		int quantidadeCompartilhamento = calcularQuantidadeCompartilhamento(quantidadeCliques);
		vizualizacoes = vizualizacoes + quantidadeCompartilhamento * 40;

		return vizualizacoes;
	}

	public double calcularValorInvestimento(Date dataInicio, Date dataFim, double investimentoDia) {
		int qtDias = calcularQuantidadeDiasDate(dataInicio, dataFim);
		double valorTotal = qtDias * investimentoDia;
		return valorTotal;

	}

	public int calcularQuantidadeDiasDate(Date dataInicio, Date dataFim) {
		int qtDias;
		qtDias = (int) ((dataFim.getTime() - dataInicio.getTime()) / (1000 * 60 * 60 * 24));
		return qtDias;

	}

	public int calcularQuantidadeCliques(int quantidadeDeVisualizacao) {
		return quantidadeDeVisualizacao / 8;
	}

	public int calcularQuantidadeCompartilhamento(int quantidadeDeCliques) {
		return quantidadeDeCliques / 6;
	}

}