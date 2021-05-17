package com.capgemini.desafio.erros;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.capgemini.desafio.service.exceptions.*;


@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcecaoDadosNaoEncontrado.class)
	public ResponseEntity<Error> dadosNaoEncontrado(ExcecaoDadosNaoEncontrado e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setError("Dado não foi encontrado em nossa base de dados, Favor tentar novamente!");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcecaoAnuncioJaExiste.class)
	public ResponseEntity<Error> ExcecaoAnuncioJaExiste(ExcecaoAnuncioJaExiste e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage(e.getMessage());
		error.setError("Nome do Anuncio já existe em nosso banco de dados, Favor tentar outro nome!");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}
}