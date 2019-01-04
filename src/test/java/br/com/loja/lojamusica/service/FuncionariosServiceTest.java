package br.com.loja.lojamusica.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.DTO.FuncionariosDTO;
import br.com.loja.lojamusica.domain.DominioInvalidoException;
import br.com.loja.lojamusica.domain.Funcionarios;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class FuncionariosServiceTest {

	@Autowired
	private FuncionariosService funService;

	@Test
	public void deveSalvarFuncionarios() {
		FuncionariosDTO funDTO = new FuncionariosDTO();
		funDTO.setNome("Abreu");
		LocalDate dataNascimento = LocalDate.of(1994, 7, 12);
		funDTO.setDataNasc(dataNascimento);
		
		funService.save(funDTO);
		
		FuncionariosDTO funcionarioSalvo = funService.findById(funDTO.getId());
		
		Assert.assertEquals(funDTO.getNome(), funcionarioSalvo.getNome());
		Assert.assertEquals(funDTO.getDataNasc(), funcionarioSalvo.getDataNasc());
		
		
	}
	@Test(expected=DominioInvalidoException.class)
	public void deveExcluirFuncionarios() {
		LocalDate dataNascimento = LocalDate.of(1994, 7, 12);
		FuncionariosDTO funDTO = new FuncionariosDTO();
		funDTO.setNome("Abreu");
		funDTO.setDataNasc(dataNascimento);
		funService.save(funDTO);
		funService.delete(funDTO.getId());
		funService.findById(funDTO.getId());
	}
	@Test
	public void deveEditarFuncionarios() {
		//1:salvando...
		LocalDate dataNascimento = LocalDate.of(1994, 7, 12);
		FuncionariosDTO funDTO = new FuncionariosDTO();
		funDTO.setNome("Abreu");
		funDTO.setDataNasc(dataNascimento);
		funService.save(funDTO);
		//2:consultando...
		FuncionariosDTO funSalvo = funService.findById(funDTO.getId());
		//3:editando...
		funSalvo.setNome("Julinho");
		funSalvo.setDataNasc( LocalDate.of(1999, 5, 1));
		//4:mandando editar...
		funService.jedit(funSalvo);
		//5:consulta para verificar a edicao
		FuncionariosDTO funEditado = funService.findById(funSalvo.getId());
		
		
		Assert.assertEquals("Julinho", funEditado.getNome());
		Assert.assertEquals(LocalDate.of(1999, 5, 1), funEditado.getDataNasc());
		
	}
}
