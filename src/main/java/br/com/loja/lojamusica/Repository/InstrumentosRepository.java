package br.com.loja.lojamusica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.lojamusica.domain.Instrumentos;


public interface InstrumentosRepository extends JpaRepository<Integer, Instrumentos> {
	
}
