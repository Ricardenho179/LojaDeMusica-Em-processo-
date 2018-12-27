package br.com.loja.lojamusica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.lojamusica.DTO.ClienteDTO;
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

	public void save(ClienteDTO clienteDTO) {
		String nome = clienteDTO.getNome();
		String email = clienteDTO.getEmail();
		String cpf = clienteDTO.getCpf();

		Cliente cliente = new Cliente(nome, email, cpf);
		cliRepository.saveAndFlush(cliente);
		clienteDTO.setId(cliente.getId());
	}

	public List<ClienteDTO> findAll() {
		List<ClienteDTO> clientesRetornando = new ArrayList<ClienteDTO>();
		List<Cliente> clientes = cliRepository.findAll();

		for (Cliente cliente : clientes) {
			ClienteDTO clienteDTO = passandoCliente(cliente);
			clientesRetornando.add(clienteDTO);
		}
		return clientesRetornando;

	}

	public ClienteDTO findByID(Integer id) {
		Optional<Cliente> clienteSalvo = cliRepository.findById(id);
		if (clienteSalvo.isPresent()) {
			return passandoCliente(clienteSalvo.get());
		}
		throw new DominioInvalidoException("Este Cliente não existe!");
	}

	private ClienteDTO passandoCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setCpf(cliente.getCpf());
		return clienteDTO;
	}
	
	public void delete(ClienteDTO clienteSalvo) {
		cliRepository.deleteById(clienteSalvo.getId());
	}

	public void edit(ClienteDTO clienteDTO) {
		Integer id = clienteDTO.getId();
		String nome = clienteDTO.getNome();
		String email = clienteDTO.getEmail();
		String cpf = clienteDTO.getCpf();

		Cliente cliente = new Cliente(id, nome, email, cpf);
		cliRepository.saveAndFlush(cliente);
	}
}
