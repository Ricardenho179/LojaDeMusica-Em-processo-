package br.com.loja.lojamusica.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.lojamusica.DTO.InstrumentosAcusticosDTO;
import br.com.loja.lojamusica.domain.DominioInvalidoException;

@RunWith(value=SpringRunner.class)
@SpringBootTest
public class InstrumentosAcusticosServiceTest {
	@Autowired
	private InstrumentosAcusticosService instruAcusService;
	
	@Test
	public void deveSalvarInstrumentosAcusticos() {
		InstrumentosAcusticosDTO instruAcusDTO = new InstrumentosAcusticosDTO();
		instruAcusDTO.setMarca("Eagle");
		instruAcusDTO.setNome("Violoncello");
		instruAcusDTO.setTipo("Corda");
		instruAcusDTO.setValor(new Double(3500.00));
		
		instruAcusService.save(instruAcusDTO);
		
		InstrumentosAcusticosDTO instrumentoAcusSalvo = instruAcusService.findById(instruAcusDTO.getId());
		
		
		Assert.assertEquals(instruAcusDTO.getMarca(), instrumentoAcusSalvo.getMarca());
		Assert.assertEquals(instruAcusDTO.getTipo(), instrumentoAcusSalvo.getTipo());
		Assert.assertEquals(instruAcusDTO.getNome(), instrumentoAcusSalvo.getNome());
		Assert.assertEquals(instruAcusDTO.getValor(), instrumentoAcusSalvo.getValor());
	}
	@Test(expected=DominioInvalidoException.class)
	public void deveExcluirInstrumentosAcusticos() {
		InstrumentosAcusticosDTO instruAcusDTO = new InstrumentosAcusticosDTO();
		instruAcusDTO.setMarca("Plander");
		instruAcusDTO.setNome("Violino");
		instruAcusDTO.setTipo("Corda");
		instruAcusDTO.setValor(new Double(2000.00));
		instruAcusService.save(instruAcusDTO);
		instruAcusService.delete(instruAcusDTO.getId());
		instruAcusService.findById(instruAcusDTO.getId());
	}
	
	@Test
	public void deveEditarInstrumentosAcusticos() {
		InstrumentosAcusticosDTO instruAcusDTO = new InstrumentosAcusticosDTO();
		//1:salvar
		instruAcusDTO.setMarca("Eagle");
		instruAcusDTO.setNome("Violoncello");
		instruAcusDTO.setTipo("Corda");
		instruAcusDTO.setValor(new Double(3500.00));
		
		instruAcusService.save(instruAcusDTO);
		//2:Consultar
		InstrumentosAcusticosDTO instruAcusSalvo = instruAcusService.findById(instruAcusDTO.getId());
		//3:Editar/Mudar os atributos para os novos editados
		instruAcusSalvo.setMarca("Stradivarius");
		instruAcusSalvo.setNome("Violoncellozao");
		instruAcusSalvo.setTipo("CordaBolada");
		instruAcusSalvo.setValor(new Double(38000000.00));
		//4:mandar Editar
		instruAcusService.edit(instruAcusSalvo);
		
		//5:Consultar para verificar
		InstrumentosAcusticosDTO instruAcusEditado = instruAcusService.findById(instruAcusSalvo.getId());
		
		Assert.assertEquals(instruAcusEditado.getMarca(), instruAcusSalvo.getMarca());
		Assert.assertEquals(instruAcusEditado.getNome(), instruAcusSalvo.getNome());
		Assert.assertEquals(instruAcusEditado.getTipo(), instruAcusSalvo.getTipo());
		Assert.assertEquals(instruAcusEditado.getValor(), instruAcusSalvo.getValor());
	}

}
