package br.com.loja.lojamusica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.domain.Cliente;
import br.com.loja.lojamusica.domain.DominioInvalidoException;
import br.com.loja.lojamusica.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository cliRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.cliRepository = clienteRepository;
	}
	
	public void save(Cliente cliente) {
		cliRepository.saveAndFlush(cliente);
	}
	
	public Cliente findByID(Integer id) {
		Optional<Cliente> clienteSalvo = cliRepository.findById(id);
		if(clienteSalvo.isPresent()) {
		return clienteSalvo.get();
		}
		throw new DominioInvalidoException("Este Cliente não existe!");
	}

	public void delete(Cliente clienteSalvo) {
		cliRepository.delete(clienteSalvo);
		
	}

	public void Edit(Cliente cliente) {
		cliRepository.saveAndFlush(cliente);
		
	}
}
