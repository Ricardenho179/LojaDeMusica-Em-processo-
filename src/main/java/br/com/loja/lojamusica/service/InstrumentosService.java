package br.com.loja.lojamusica.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.loja.lojamusica.Repository.InstrumentosRepository;

public class InstrumentosService {
	
	private InstrumentosRepository instruRepository;
	
	@Autowired
	public InstrumentosService(InstrumentosRepository instruRepository) {
		
	}

}
