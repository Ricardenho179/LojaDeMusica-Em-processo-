package br.com.loja.lojamusica.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.domain.DominioInvalidoException;
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
	@Test(expected=DominioInvalidoException.class)
	public void deveExcluirFuncionarios() {
		LocalDate dataNascimento = LocalDate.of(1994, 7, 12);
		Funcionarios funcionarios = new Funcionarios("Abreu", dataNascimento);
		funService.save(funcionarios);
		funService.delete(funcionarios);
		funService.findById(funcionarios.getId());
	}
	@Test
	public void deveEditarFuncionarios() {
		LocalDate dataNascimento = LocalDate.of(1994, 7, 12);
		Funcionarios funcionarios = new Funcionarios("Abreu", dataNascimento);
		funService.save(funcionarios);
		
		Funcionarios funSalvo = funService.findById(funcionarios.getId());
		
		LocalDate newDataNascimento = LocalDate.of(1999, 1, 10);
		Funcionarios funEditado = new Funcionarios(funcionarios.getId(), "Cristóvam", newDataNascimento);
		funService.jedit(funEditado);
		
		Assert.assertEquals("Cristóvam", funEditado.getNome());
		Assert.assertEquals(newDataNascimento, funEditado.getDataNasc());
	}
}
