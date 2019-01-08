package br.com.loja.lojamusica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.lojamusica.domain.InstrumentosEletricos;


public interface InstrumentosEletricosRepository extends JpaRepository<InstrumentosEletricos, Integer> {
	
}
