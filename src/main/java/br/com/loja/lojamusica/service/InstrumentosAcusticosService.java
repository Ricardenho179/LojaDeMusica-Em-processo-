package br.com.loja.lojamusica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.repository.InstrumentosAcusticosRepository;

@Service
public class InstrumentosAcusticosService {

	private InstrumentosAcusticosRepository InstruAcusRepository;
	
	@Autowired
	public InstrumentosAcusticosService(InstrumentosAcusticosRepository InstruAcusRepository) {
		this.InstruAcusRepository = InstruAcusRepository;
		
	}
	//Queria salvar uma lista de instrumentos
	public void save() {
		
	}
	public void findById() {
		
	}
	
	public void delete() {
		
	}
	
	public void jedit() {
		
	}
}
