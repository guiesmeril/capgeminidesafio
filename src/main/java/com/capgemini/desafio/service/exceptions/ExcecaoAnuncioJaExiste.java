package com.capgemini.desafio.service.exceptions;

public class ExcecaoAnuncioJaExiste extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcecaoAnuncioJaExiste(String msg) {
		super(msg);
	}
}
