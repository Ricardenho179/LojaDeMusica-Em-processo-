package br.com.loja.lojamusica.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.domain.Funcionarios;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class FuncionariosServiceTest {

	@Autowired
	private FuncionariosService funService;

	@Test
	public void deveSalvarFuncionarios() {
		LocalDate dataNascimento = LocalDate.of(1994, 7, 12);
		Funcionarios funcionarios = new Funcionarios("Abreu", dataNascimento);
		funService.save(funcionarios);
		
		Funcionarios funcionarioSalvo = funService.findById(funcionarios.getId());
		
		Assert.assertEquals(funcionarios, funcionarioSalvo);
		
	}
}
