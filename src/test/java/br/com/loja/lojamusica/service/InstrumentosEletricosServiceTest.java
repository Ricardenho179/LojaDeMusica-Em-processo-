package br.com.loja.lojamusica.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.DTO.InstrumentosEletricosDTO;
import br.com.loja.lojamusica.domain.DominioInvalidoException;

@RunWith(value=SpringRunner.class)
@SpringBootTest
public class InstrumentosEletricosServiceTest {
	
	@Autowired
	private InstrumentosEletricosService instruService;
	
	@Test
	public void deveSalvarInstrumentosEletricos() {
		InstrumentosEletricosDTO instruDTO = new InstrumentosEletricosDTO();
		instruDTO.setTipo("Corda");
		instruDTO.setMarca("Gibson");
		instruDTO.setNome("Guitarra");
		instruDTO.setAmplificador("Valvetronix");
		instruDTO.setCaixaSom("Datrel");
		instruDTO.setValor(new Double(6000.00));
		
		instruService.salvar(instruDTO);
		//Nao esquecer de pesquisar
		InstrumentosEletricosDTO instrumentosSalvos = instruService.findById(instruDTO.getId());
		
		Assert.assertEquals("Corda", instrumentosSalvos.getTipo());
		Assert.assertEquals("Gibson", instrumentosSalvos.getMarca());
		Assert.assertEquals("Guitarra", instrumentosSalvos.getNome());
		Assert.assertEquals("Valvetronix", instrumentosSalvos.getAmplificador());
		Assert.assertEquals("Datrel", instrumentosSalvos.getCaixaSom());
		Assert.assertEquals(new Double(6000.00), instrumentosSalvos.getValor());
		
	}
	@Test(expected=DominioInvalidoException.class)
	public void deveDeletarInstrumentosEletricos() {
		InstrumentosEletricosDTO instruDTO = new InstrumentosEletricosDTO();
		instruDTO.setTipo("Corda");
		instruDTO.setMarca("Gibson");
		instruDTO.setNome("Guitarra");
		instruDTO.setAmplificador("Valvetronix");
		instruDTO.setCaixaSom("Datrel");
		instruDTO.setValor(new Double(6000.00));
		
		instruService.salvar(instruDTO);
		
		instruService.deletar(instruDTO.getId());
		
		instruService.findById(instruDTO.getId());
		
	}
	@Test
	public void deveEditarInstrumentosEletricos() {
		//1:Salvar
		InstrumentosEletricosDTO instruDTO = new InstrumentosEletricosDTO();
		instruDTO.setTipo("Corda");
		instruDTO.setMarca("Gibson");
		instruDTO.setNome("Guitarra");
		instruDTO.setAmplificador("Valvetronix");
		instruDTO.setCaixaSom("Datrel");
		instruDTO.setValor(new Double(6000.00));
		
		instruService.salvar(instruDTO);
		//2:Pesquisar
		InstrumentosEletricosDTO instrumentoSalvo = instruService.findById(instruDTO.getId());
		//3:Mandar editar
		instrumentoSalvo.setTipo("Percussao");
		instrumentoSalvo.setMarca("ALAHUAKIBA");
		instrumentoSalvo.setNome("BateriaEletrica");
		instrumentoSalvo.setAmplificador("Ojsghdhg");
		instrumentoSalvo.setCaixaSom("idugyweuf23");
		instrumentoSalvo.setValor(new Double(1000.00));
		//4:Editar
		instruService.edit(instrumentoSalvo);
		//5:consultar novamente
		InstrumentosEletricosDTO intrumentoEditado = instruService.findById(instrumentoSalvo.getId());
		
		
		Assert.assertEquals("Percussao", instrumentoSalvo.getTipo());
		Assert.assertEquals("ALAHUAKIBA", instrumentoSalvo.getMarca());
		Assert.assertEquals("BateriaEletrica", instrumentoSalvo.getNome());
		Assert.assertEquals("Ojsghdhg", instrumentoSalvo.getAmplificador());
		Assert.assertEquals("idugyweuf23", instrumentoSalvo.getCaixaSom());
		Assert.assertEquals(new Double(1000.00), instrumentoSalvo.getValor());
	}
}