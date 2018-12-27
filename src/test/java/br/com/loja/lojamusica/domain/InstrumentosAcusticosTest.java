package br.com.loja.lojamusica.domain;

import org.junit.Assert;
import org.junit.Test;

public class InstrumentosAcusticosTest {
	@Test
	public void deveCriarInstrumentosAcusticos() {
		InstrumentosAcusticos instruA = new InstrumentosAcusticos("Cordas", "Violoncello", "Eagle", 2000.00);
		
		
		Assert.assertEquals("Cordas", instruA.getTipo());
		Assert.assertEquals("Violoncello", instruA.getNome());
		Assert.assertEquals("Eagle", instruA.getMarca());
		Assert.assertEquals( new Double(2000.00), instruA.getValor());
		
	}

}
