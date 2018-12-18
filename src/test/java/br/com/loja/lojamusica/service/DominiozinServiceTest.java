package br.com.loja.lojamusica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.domain.DominioInvalidoException;
import br.com.loja.lojamusica.domain.Dominiozin;
import br.com.loja.lojamusica.repository.DominiozinRepository;



@RunWith(value = SpringRunner.class)
@SpringBootTest
public class DominiozinServiceTest {
	
	@Autowired
	private DominiozinService domService;
	
	@Test
	public void deveSalvarUmDominiozin() {
		Dominiozin dom = new Dominiozin("NomeQualquer");
		domService.save(dom);
		
		Dominiozin domSalvo = domService.findByID(dom.getId());
		Assert.assertEquals("NomeQualquer", domSalvo.getNome());
		
	}
	
	@Test(expected=DominioInvalidoException.class)
	public void deveExcluirUmDominiozin() {
		Dominiozin dom = new Dominiozin("NomeQualquer");
		domService.save(dom);
		
		domService.delete(dom);
		
		domService.findByID(dom.getId());
	}
	
	@Test
	public void deveEditarUmDominiozin() {
		Dominiozin dom = new Dominiozin("NomeQualuquer");
		domService.save(dom);
		Dominiozin dominiozinhoSalvo = domService.findByID(dom.getId());
		
		Dominiozin dominioParaAtualizar = new Dominiozin(dominiozinhoSalvo.getId(), "Novo Nome");
		
		domService.update(dominioParaAtualizar);
		Dominiozin dominiozinhoAtualizado= domService.findByID(dom.getId());
		Assert.assertEquals("Novo Nome", dominiozinhoAtualizado.getNome());
	}
	
	

}
