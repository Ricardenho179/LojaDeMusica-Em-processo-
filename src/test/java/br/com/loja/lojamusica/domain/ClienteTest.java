package br.com.loja.lojamusica.domain;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	@Test
	public void deveCriarUmCliente() {
		Cliente cliente = new Cliente("Cristiano", "CristianoDoPagode@hotmail.com", "73262221007");
		
		Assert.assertEquals("Cristiano", cliente.getNome());
		Assert.assertEquals("CristianoDoPagode@hotmail.com", cliente.getEmail());
		Assert.assertEquals("73262221007", cliente.getCpf());
	
	}
	

}
