package fiuba.algo3.tp2.integracion.entrega1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

import java.math.BigDecimal;

public class MaterialTest {

	@Test
	public void dadaUnHachaDeMadera_AlUsarlaContraMadera_DeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {
		
		Material madera = new Madera();
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		
		// Se golpea la madera con el hacha hasta destruirla
		assertEquals(new BigDecimal(10), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new BigDecimal(8), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new BigDecimal(6), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new BigDecimal(4), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new BigDecimal(2), madera.getDurabilidad());
		hachaMadera.golpear(madera);
		assertEquals(new BigDecimal(0), madera.getDurabilidad());
		/*
		try {
			hachaMadera.golpear(madera);
			fail("Should throw MaterialDestruidoNoSePuedeGolpearException");
		} catch(Exception exception) {
			assertEquals(MaterialDestruidoNoSePuedeGolpearException.class, exception.getClass());
		}
		
		 */
	}
	
	@Test
	public void DadaUnaPiedra_AlGolpearseContraCualquierTipoDeHacha_NoDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Material piedra = new Piedra();
		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		
		BigDecimal durabilidadPiedra = piedra.getDurabilidad();
		assertEquals(new BigDecimal(30), durabilidadPiedra);
		
		// Se golpea varias veces la piedra con las distintas hachas
		// y se verifica que no se reduce la durabilidad del metal
		hachaMadera.golpear(piedra);
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
		
		hachaMadera.golpear(piedra);
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
		
		hachaPiedra.golpear(piedra);
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
		
		hachaPiedra.golpear(piedra);
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
		
		hachaMetal.golpear(piedra);
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
		
		hachaMetal.golpear(piedra);
		assertEquals(durabilidadPiedra, piedra.getDurabilidad());
	}
	
	@Test
	public void dadoUnPicoDePiedra_AlGolpearUnMetal_NoDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Material metal = new Metal();
		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		
		BigDecimal durabilidadMetal = metal.getDurabilidad();
		assertEquals(new BigDecimal(50), durabilidadMetal);
		
		// Se golpea varias veces el metal con el pico 
		// y se verifica que no se reduce la durabilidad del metal
		picoMadera.golpear(metal);
		assertEquals(durabilidadMetal, metal.getDurabilidad());
		
		picoMadera.golpear(metal);
		assertEquals(durabilidadMetal, metal.getDurabilidad());
		
		picoMadera.golpear(metal);
		assertEquals(durabilidadMetal, metal.getDurabilidad());
	}
}
