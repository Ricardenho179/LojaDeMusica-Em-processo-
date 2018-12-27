package br.com.loja.lojamusica.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.domain.DominioInvalidoException;
import br.com.loja.lojamusica.domain.Funcionarios;
import br.com.loja.lojamusica.repository.FuncionariosRepository;

@Service
public class FuncionariosService {

	private FuncionariosRepository funRepository;

	@Autowired
	public FuncionariosService(FuncionariosRepository funRepository) {
		this.funRepository = funRepository;

	}

	public void save(Funcionarios funcionarios) {
		funRepository.saveAndFlush(funcionarios);
	}

	public Funcionarios findById(Integer id) {
		Optional<Funcionarios> funcionarioSalvo = funRepository.findById(id);
		if(funcionarioSalvo.isPresent()) {
			return funcionarioSalvo.get();
		}
		throw new DominioInvalidoException("Funcionário não encontrado... Pesquisa dnv") ;
	}

	public void delete(Funcionarios funcionarios) {
		funRepository.delete(funcionarios);
	}

	public void jedit(Funcionarios funcionarios) {
		funRepository.saveAndFlush(funcionarios);
	}
}
