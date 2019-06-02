package fiuba.algo3.tp2.integracion.entrega1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.Hacha;
import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.herramienta.durabilidad.DurabilidadLineal;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeMadera;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

public class MaterialTest {

	@Test
	public void DadaUnHachaDeMadera_AlUsarlaContraMadera_DeberiaReducirSuDurabilidad() 
			throws Exception {
		
		Material madera = new Madera();
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		
		assertEquals(new Integer(10), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new Integer(8), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new Integer(6), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new Integer(4), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new Integer(2), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new Integer(0), madera.getDurabilidad());
		
		try {
			hachaMadera.golpear(madera);
			fail("Should throw MaterialDestruidoNoSePuedeGolpearException");
		} catch(Exception exception) {
			assertEquals(MaterialDestruidoNoSePuedeGolpearException.class, exception.getClass());
		}
	}
}
