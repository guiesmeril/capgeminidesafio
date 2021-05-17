package com.capgemini.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.capgemini.desafio.interfaces.AnuncioInterface;
import com.capgemini.desafio.model.Anuncio;
import com.capgemini.desafio.model.Relatorio;
import com.capgemini.desafio.service.AnuncioService; 

@Controller
public class AnuncioController implements AnuncioInterface {

	@Autowired
	private AnuncioService anuncioService;

	@Override
	public ResponseEntity<Anuncio> insert(Anuncio anuncio) {
		Anuncio response = anuncioService.insert(anuncio);
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<List<Relatorio>> find(String name, String dataInicio, String dataFim) {
		List<Relatorio> response =  anuncioService.find(name, dataInicio, dataFim);
		return ResponseEntity.ok().body(response);
	}

}
