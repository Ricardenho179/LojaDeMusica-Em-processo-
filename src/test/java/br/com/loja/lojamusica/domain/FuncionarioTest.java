package br.com.loja.lojamusica.domain;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class FuncionarioTest {
	@Test
	public void deveCriarFuncionarios() {
		LocalDate dataNascimento = LocalDate.of(1994, 7, 12);
		Funcionarios funcionarios = new Funcionarios("Abreu", dataNascimento);
			
		
		Assert.assertEquals("Abreu", funcionarios.getNome());
		Assert.assertNotNull(dataNascimento);
		
	}

}
