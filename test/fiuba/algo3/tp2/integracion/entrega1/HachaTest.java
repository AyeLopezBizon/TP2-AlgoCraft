package fiuba.algo3.tp2.integracion.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.Hacha;

public class HachaTest {

	@Test
	public void test01AlUsarUnHachaSuDurabilidadDisminuyeDeAUno() {
		Hacha hacha = new Hacha();
		//malisimo
		assertTrue(hacha.usar()==99);
		
	}

}
