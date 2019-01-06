package br.com.loja.lojamusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.DTO.FuncionariosDTO;
import br.com.loja.lojamusica.DTO.InstrumentosAcusticosDTO;
import br.com.loja.lojamusica.Repository.InstrumentosAcusticosRepository;
import br.com.loja.lojamusica.domain.DominioInvalidoException;
import br.com.loja.lojamusica.domain.Funcionarios;
import br.com.loja.lojamusica.domain.InstrumentosAcusticos;

@Service
public class InstrumentosAcusticosService {

	private InstrumentosAcusticosRepository instruAcusRepository;
	
	@Autowired
	public InstrumentosAcusticosService(InstrumentosAcusticosRepository instruAcusRepository) {
		this.instruAcusRepository = instruAcusRepository;
		
	}
	//Queria salvar uma lista de instrumentos
	public void save(InstrumentosAcusticosDTO instruAcusDTO) {
		String tipo = instruAcusDTO.getTipo();
		String marca = instruAcusDTO.getMarca();
		String nome = instruAcusDTO.getNome();
		double valor = instruAcusDTO.getValor();
		
		InstrumentosAcusticos instruAcus = new InstrumentosAcusticos(tipo, nome, marca, valor);
		instruAcusRepository.saveAndFlush(instruAcus);
		instruAcusDTO.setId(instruAcus.getId());
	}
	//método de percorrer
	public InstrumentosAcusticosDTO findById(Integer id) {
		Optional<InstrumentosAcusticos> instrumentoAcusSalvo = instruAcusRepository.findById(id);
		if(instrumentoAcusSalvo.isPresent()) {
			return traduzindoInstrumentosAcusticos(instrumentoAcusSalvo.get());
		}
		throw new DominioInvalidoException("Instrumento não existe! Pesquisa dnv") ;
	}
	//método auxiliar para percorrer
	private InstrumentosAcusticosDTO traduzindoInstrumentosAcusticos(InstrumentosAcusticos instruAcus)  {
		InstrumentosAcusticosDTO InstrAcusDTO = new InstrumentosAcusticosDTO();
		InstrAcusDTO.setId(instruAcus.getId());
		InstrAcusDTO.setTipo(instruAcus.getTipo());
		InstrAcusDTO.setMarca(instruAcus.getMarca());
		InstrAcusDTO.setValor(instruAcus.getValor());
		InstrAcusDTO.setNome(instruAcus.getNome());
		return InstrAcusDTO;
	}
		
	
	
	public void delete(Integer id) {
		instruAcusRepository.deleteById(id);
	}
	
	public void jedit(InstrumentosAcusticosDTO instruAcusDTO) {
		Integer id = instruAcusDTO.getId();
		String tipo = instruAcusDTO.getTipo();
		String marca = instruAcusDTO.getMarca();
		String nome = instruAcusDTO.getNome();
		double valor = instruAcusDTO.getValor();
		InstrumentosAcusticos instruAcus = new InstrumentosAcusticos(id, tipo, nome, marca, valor);
	}
	//método para 
	public void findAll() {
		
	}
}
