package com.capgemini.desafio.service;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.desafio.rn.RegraNegocio;
import com.capgemini.desafio.service.exceptions.ExcecaoAnuncioJaExiste;

@SpringBootTest
class AnuncioServiceTest {
	
	@Autowired
	private RegraNegocio regraNegocio;

	@Test
	@DisplayName ("Verificar se o nome do Anuncio já existe cadastrado")
	void verificarSeNomeDoAnuncioJaExiste() {
		String nomeAnuncio = "Sorteio CB1001";
		assertThrows(ExcecaoAnuncioJaExiste.class, () -> regraNegocio.verificarAnuncioJaExiste(nomeAnuncio));
	}

}
