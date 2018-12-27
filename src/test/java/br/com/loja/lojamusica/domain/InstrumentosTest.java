package br.com.loja.lojamusica.domain;

import org.junit.Assert;
import org.junit.Test;

public class InstrumentosTest {
	@Test
	public void deveCriarInstrumentosEletricos() {
		Instrumentos instru = new Instrumentos("Percussão","BateriaEletrica", "XPRO","Roland", "Roland", 4000.00);
		Assert.assertEquals("Percussão", instru.getTipo());
		Assert.assertEquals("BateriaEletrica", instru.getNome());
		Assert.assertEquals("XPRO", instru.getMarca());
		Assert.assertEquals("Roland", instru.getAmplificador());
		Assert.assertEquals("Roland", instru.getCaixaSom());
		Assert.assertEquals(new Double(4000.00), instru.getValor());
	}

}
