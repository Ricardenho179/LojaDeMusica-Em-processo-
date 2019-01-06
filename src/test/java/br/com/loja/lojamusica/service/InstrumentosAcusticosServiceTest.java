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
//	@Test(expected=DominioInvalidoException.class)
//	public void deveExcluirInstrumentosAcusticos() {
//		
//	}
//	
//	@Test
//	public void deveEditarInstrumentosAcusticos() {
//		
//	}

}
