package com.capgemini.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.desafio.model.Anuncio;
import com.capgemini.desafio.model.Relatorio;
import com.capgemini.desafio.repository.AnuncioRepository;
import com.capgemini.desafio.rn.RegraNegocio;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository anuncioRepository;

	@Autowired
	private RegraNegocio regraNegocio;

	public Anuncio insert(Anuncio request) {
		
		regraNegocio.verificarAnuncioJaExiste(request.getNomeAnuncio());
		
		Anuncio anuncio = new Anuncio();
		anuncio.setNomeAnuncio(request.getNomeAnuncio());
		anuncio.setInvestimento(request.getInvestimento());
		anuncio.setDataInicio(request.getDataInicio());
		anuncio.setDataFim(request.getDataFim());
		anuncio.setNomeCliente(request.getNomeCliente());
		anuncioRepository.save(anuncio);
		return anuncio;

	}

	public List<Relatorio> find(String name, String dataInicio, String dataFim) {

		List<Anuncio> listAnuncio = new ArrayList<>();
		List<Relatorio> listaRelatorio = new ArrayList<>();

		if (name == null && dataInicio == null && dataFim == null) {
			listAnuncio = anuncioRepository.findAnuncio(); 
			listaRelatorio = retornoListaRelatorio(listAnuncio);
		}

		if (name != null) {
			listAnuncio = anuncioRepository.findAnuncio(name);
			listaRelatorio = retornoListaRelatorio(listAnuncio);
		}

		if (dataInicio != null && dataFim != null) {
			listAnuncio = anuncioRepository.findAnuncio(dataInicio, dataFim);
			listaRelatorio = retornoListaRelatorio(listAnuncio);
		}

		return listaRelatorio;
	}

	public List<Relatorio> retornoListaRelatorio(List<Anuncio> anuncios) {
		List<Relatorio> listaRelatorio = new ArrayList<>();

		for (Anuncio anuncio : anuncios) {
			Relatorio relatorio = new Relatorio();

			double valorTotalInvestido = regraNegocio.calcularValorInvestimento(anuncio.getDataInicio(),
					anuncio.getDataFim(), anuncio.getInvestimento());
			int quantidadeMaximaVizualicoes = regraNegocio.calcularMaximaVisualizacao(anuncio.getDataInicio(),
					anuncio.getDataFim(), anuncio.getInvestimento());
			
			int quantidadeCliques = regraNegocio.calcularQuantidadeCliques(quantidadeMaximaVizualicoes);
			int quantidadeCompartilhamento = regraNegocio.calcularQuantidadeCompartilhamento(quantidadeCliques);

			relatorio.setIdAnuncio(anuncio.getIdAnuncio());
			relatorio.setNomeAnuncio(anuncio.getNomeAnuncio());
			relatorio.setNomeCliente(anuncio.getNomeCliente());
			relatorio.setValorTotalInvestido(valorTotalInvestido);
			relatorio.setQuantidadeMaximaVisualizacoes(quantidadeMaximaVizualicoes);
			relatorio.setQuantidadeMaximaCliques(quantidadeCliques);
			relatorio.setQuantidadeMaximaCompartilhamentos(quantidadeCompartilhamento);
			relatorio.setDataInicio(anuncio.getDataInicio());
			relatorio.setDataFim(anuncio.getDataFim());
			listaRelatorio.add(relatorio);

		}

		return listaRelatorio;

	}


}
