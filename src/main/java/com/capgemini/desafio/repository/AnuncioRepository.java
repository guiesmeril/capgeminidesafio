package com.capgemini.desafio.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.desafio.model.Anuncio;

@Repository
public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {

	@Modifying
	@Query(value = "Select * from Anuncio", nativeQuery = true)
	@Transactional
	List<Anuncio> findAnuncio();

	@Modifying
	@Query(value = "Select * from Anuncio where nome_cliente = :name", nativeQuery = true)
	@Transactional
	List<Anuncio> findAnuncio(@Param("name") String name);

	@Modifying
	@Query(value = "SELECT * FROM ANUNCIO where data_inicio >= :dataInicio and data_fim <= :dataFim ", nativeQuery = true)
	@Transactional
	List<Anuncio> findAnuncio(@Param("dataInicio") String dataInicio, @Param("dataFim") String dataFim);
	
	@Modifying
	@Query(value = "Select * from Anuncio where nome_anuncio = :nome_anuncio", nativeQuery = true)
	@Transactional
	List<Anuncio> findNomeAnuncio(@Param("nome_anuncio") String nomeAnuncio);
}
