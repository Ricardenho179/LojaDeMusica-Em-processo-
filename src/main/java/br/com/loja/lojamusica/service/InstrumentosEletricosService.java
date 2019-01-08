package br.com.loja.lojamusica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.DTO.InstrumentosEletricosDTO;
import br.com.loja.lojamusica.Repository.InstrumentosEletricosRepository;
import br.com.loja.lojamusica.domain.DominioInvalidoException;
import br.com.loja.lojamusica.domain.InstrumentosEletricos;
@Service
public class InstrumentosEletricosService {
	
	private InstrumentosEletricosRepository instruRepository;
	
	@Autowired
	public InstrumentosEletricosService(InstrumentosEletricosRepository instruRepository) {
		this.instruRepository = instruRepository;
		
	}

	public void salvar(InstrumentosEletricosDTO instruDTO) {
		String tipo = instruDTO.getTipo();
		String nome = instruDTO.getNome();
		String marca = instruDTO.getMarca();
		String  amplificador= instruDTO.getAmplificador();
		String caixaSom = instruDTO.getCaixaSom();
		double valor = instruDTO.getValor();
		
		
		InstrumentosEletricos instru = new InstrumentosEletricos(tipo, nome, marca, amplificador, caixaSom, valor);
		instruRepository.saveAndFlush(null);
		instruDTO.setId(instru.getId());
	}
	
	public void deletar(Integer id) {
		instruRepository.deleteById(id);
		
	}
	public void edit(InstrumentosEletricosDTO instruDTO) {
		Integer id = instruDTO.getId();
		String tipo = instruDTO.getTipo();
		String nome = instruDTO.getNome();
		String marca = instruDTO.getMarca();
		String amplificador = instruDTO.getAmplificador();
		String caixaSom = instruDTO.getCaixaSom();
		double valor = instruDTO.getValor(); 
		InstrumentosEletricos instru = new InstrumentosEletricos(id, tipo, nome, marca, amplificador, caixaSom, valor);
		instruRepository.saveAndFlush(instru);
		
		
	}
	public InstrumentosEletricosDTO findById(Integer id) {
		Optional<InstrumentosEletricos> instrumentosEletricos = instruRepository.findById(id);
		if(instrumentosEletricos.isPresent()) {
			return traduzindoInstrumentosEletricos(instrumentosEletricos.get());
		}
		throw new DominioInvalidoException("Instrumento não existe! Pesquisa dnv");
	}
	
	
	//método auxiliar para percorrer
	private InstrumentosEletricosDTO traduzindoInstrumentosEletricos (InstrumentosEletricos instru) {
		InstrumentosEletricosDTO instruDTO = new InstrumentosEletricosDTO();
		instruDTO.setTipo(instru.getTipo());
		instruDTO.setMarca(instru.getMarca());
		instruDTO.setNome(instru.getNome());
		instruDTO.setAmplificador(instru.getAmplificador());
		instruDTO.setCaixaSom(instru.getCaixaSom());
		
		return instruDTO;
	}
	//método para q o controller possa pegar uma lista deste objeto e mostrar
	public List<InstrumentosEletricosDTO> findAll() {
		List<InstrumentosEletricosDTO> instrumentosEletricosRertonando = new ArrayList <InstrumentosEletricosDTO>();
		
		List<InstrumentosEletricos> instru = instruRepository.findAll();
		
		for (InstrumentosEletricos instrumentos: instru) {
			//Tradução dos dados DTO para Dominio
			InstrumentosEletricosDTO instruDTO = traduzindoInstrumentosEletricos(instrumentos);
			instrumentosEletricosRertonando.add(instruDTO);
		}
		return instrumentosEletricosRertonando;
	}
	
	}
