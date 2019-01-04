package br.com.loja.lojamusica.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.DTO.FuncionariosDTO;
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

	public void save(FuncionariosDTO funcionariosDTO) {
		String nome = funcionariosDTO.getNome();
		
		LocalDate dataNasc = funcionariosDTO.getDataNasc();
		
		
		Funcionarios funcionarios =new Funcionarios(nome, dataNasc);
		funRepository.saveAndFlush(funcionarios);
		funcionariosDTO.setId(funcionarios.getId());
	}

	public FuncionariosDTO findById(Integer id) {
		Optional<Funcionarios> funcionarioSalvo = funRepository.findById(id);
		if(funcionarioSalvo.isPresent()) {
			return traduzindoFuncionarios(funcionarioSalvo.get());
		}
		throw new DominioInvalidoException("Funcionário não encontrado... Pesquisa dnv") ;
	}

	private FuncionariosDTO traduzindoFuncionarios(Funcionarios funcionarios)  {
		FuncionariosDTO funDTO = new FuncionariosDTO();
		funDTO.setId(funcionarios.getId());
		funDTO.setDataNasc(funcionarios.getDataNasc());
		funDTO.setNome(funcionarios.getNome());
		return funDTO;
	}
	
	
	public void delete(Integer id) {
		funRepository.deleteById(id);
	}

	public void jedit(FuncionariosDTO funcionariosDTO) {
		Integer id = funcionariosDTO.getId();
		String nome = funcionariosDTO.getNome();
		LocalDate dataNasc = funcionariosDTO.getDataNasc();
		Funcionarios funcionarios = new Funcionarios(id, nome, dataNasc);
		funRepository.saveAndFlush(funcionarios);
	}

	public List<FuncionariosDTO> findAll() {
		List<FuncionariosDTO> funcionariosRetornando = new ArrayList<FuncionariosDTO>();
		List<Funcionarios> funcionarios = funRepository.findAll();
		
		for (Funcionarios funcionario: funcionarios) {
			FuncionariosDTO funDTO =  traduzindoFuncionarios(funcionario);
			funcionariosRetornando.add(funDTO);
			
		}
		return funcionariosRetornando;
	}
}
