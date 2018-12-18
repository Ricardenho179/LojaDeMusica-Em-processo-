package br.com.loja.lojamusica.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.domain.Cliente;
import br.com.loja.lojamusica.domain.DominioInvalidoException;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {

	@Autowired
	private ClienteService cliService;

	@Test
	public void deveSalvarClientes() {
		Cliente cliente = new Cliente("Cristiano", "CristianoDoPagode@hotmail.com", "73262221007");
		cliService.save(cliente);

		Cliente clienteSalvo = cliService.findByID(cliente.getId());

		Assert.assertEquals(cliente, clienteSalvo);
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveExcluirClientes() {
		Cliente cliente = new Cliente("Cristiano", "CristianoDoPagode@hotmail.com", "73262221007");
		cliService.save(cliente);
//		Cliente clienteSalvo = cliService.findByID(cliente);
//		cliService.delete(clienteSalvo);
// Não pode colocar o findById armazenado em uma variavel "ClienteSalvo" e deletar o teste falha
		cliService.delete(cliente);
		cliService.findByID(cliente.getId());
	}
	@Test
	public void deveEditarClientes() {
		Cliente cliente = new Cliente("Cristiano", "CristianoDoPagode@hotmail.com", "73262221007");
		cliService.save(cliente);
		
		Cliente clienteSalvo = cliService.findByID(cliente.getId());
		
		Cliente clienteEditado = new Cliente(clienteSalvo.getId(), "Olavo", "OlavoDoPagode@gmail.com", "03486008013");
		
		cliService.Edit(clienteEditado);

		Assert.assertEquals("Olavo" , clienteEditado.getNome());
		Assert.assertEquals("OlavoDoPagode@gmail.com" , clienteEditado.getEmail());
		Assert.assertEquals("03486008013" , clienteEditado.getCpf());
		
		
	}

}
