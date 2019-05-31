package fiuba.algo3.tp2.integracion.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.Hacha;
import fiuba.algo3.tp2.Herramienta;

public class HerramientaTest {

	@Test
	public void test_01_AlCrearUnHachaDeMadera_SuDurabilidadDeberiaSer100YSuFuerza2() {
		
		Herramienta hacha = new Hacha();
		
		assertEquals(new Integer(100), hacha.getDurabilidad());
		assertEquals(new Integer(3), hacha.getFuerza());
	}
}
