package com.capgemini.desafio.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.desafio.model.Anuncio;
import com.capgemini.desafio.model.Relatorio;

@RequestMapping("/anuncio")
public interface AnuncioInterface {

	@PostMapping
	public ResponseEntity<Anuncio> insert(@RequestBody Anuncio anuncio);

	@GetMapping 
	public ResponseEntity<List<Relatorio>> find(@RequestParam(required = false) String name, String dataInicio, String dataFim);

	 

}
