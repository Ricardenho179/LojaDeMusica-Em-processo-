package br.com.loja.lojamusica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.domain.DominioInvalidoException;
import br.com.loja.lojamusica.domain.Dominiozin;
import br.com.loja.lojamusica.repository.DominiozinRepository;

@Service
public class DominiozinService {

	private DominiozinRepository domRepository;

	// Construtor do cara q será utilizado
	@Autowired
	public DominiozinService(DominiozinRepository dominiozinRepository) {
		this.domRepository = dominiozinRepository;
	}

	public void save(Dominiozin abacaxi) {
		domRepository.saveAndFlush(abacaxi);
	}

	public Dominiozin findByID(Integer id) {
		Optional<Dominiozin> dominiozinSalvo = domRepository.findById(id);
		if (dominiozinSalvo.isPresent()) {
			return dominiozinSalvo.get();
		}
		throw new DominioInvalidoException("Este Dominiozin nem existe kkkj");
	}

	//o método Delete ja existe porém eu crio eu método apenas para poder chamar no service
	//pois a web não conhece o Repository
	public void delete(Dominiozin abacaxi) {
		domRepository.delete(abacaxi);
	}

	public void update(Dominiozin abacaxi) {
		domRepository.saveAndFlush(abacaxi);
		
	}
}
