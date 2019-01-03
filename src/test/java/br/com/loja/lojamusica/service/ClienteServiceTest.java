package br.com.loja.lojamusica.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.DTO.ClienteDTO;
import br.com.loja.lojamusica.domain.DominioInvalidoException;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {

	@Autowired
	private ClienteService cliService;

	@Test
	public void deveSalvarClientes() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setEmail("CristianoDoPagode@hotmail.com");
		clienteDTO.setNome("Cristiano");
		clienteDTO.setCpf("73262221007");
		
		
		cliService.save(clienteDTO);

		ClienteDTO clienteSalvo = cliService.findByID(clienteDTO.getId());

		Assert.assertEquals(clienteDTO.getEmail(), clienteSalvo.getEmail());
		Assert.assertEquals(clienteDTO.getNome(), clienteSalvo.getNome());
		Assert.assertEquals(clienteDTO.getCpf(), clienteSalvo.getCpf());
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveExcluirClientes() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setEmail("CristianoDoPagode@hotmail.com");
		clienteDTO.setNome("Cristiano");
		clienteDTO.setCpf("73262221007");
		
		cliService.save(clienteDTO);
//		Cliente clienteSalvo = cliService.findByID(cliente);
//		cliService.delete(clienteSalvo);
// Não pode colocar o findById armazenado em uma variavel "ClienteSalvo" e deletar o teste falha
		cliService.delete(clienteDTO.getId());
		cliService.findByID(clienteDTO.getId());
	}
	@Test
	public void deveEditarClientes() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setEmail("CristianoDoPagode@hotmail.com");
		clienteDTO.setNome("Cristiano");
		clienteDTO.setCpf("73262221007");
		
		// mando salvar
		cliService.save(clienteDTO);
		
		// consulto
		ClienteDTO clienteParaEditar = cliService.findByID(clienteDTO.getId());
		
		// altero os dados
		clienteParaEditar.setNome("Olavo");
		clienteParaEditar.setEmail("OlavoDoPagode@gmail.com");
		clienteParaEditar.setCpf("03486008013");
		
		// mando editar
		cliService.edit(clienteParaEditar);

		// consulto para validar a edição
		ClienteDTO clienteEditado = cliService.findByID(clienteParaEditar.getId());
		
		Assert.assertEquals("Olavo" , clienteEditado.getNome());
		Assert.assertEquals("OlavoDoPagode@gmail.com" , clienteEditado.getEmail());
		Assert.assertEquals("03486008013" , clienteEditado.getCpf());
	}

}
