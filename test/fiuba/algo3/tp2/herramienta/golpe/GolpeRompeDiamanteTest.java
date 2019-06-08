package fiuba.algo3.tp2.herramienta.golpe;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

public class GolpeRompeDiamanteTest {

	
	@Test
	public void cuandoUnGolpeRompeDiamanteGolpeaMadera_DeberiaReducirLaDurabilidaDelMaterialEn20() 
			throws Exception {
		
		Golpe golpeRompeDiamente = new GolpeRompeDiamante(new BigDecimal(20));
		Golpeable madera = new Madera();
		
		golpeRompeDiamente.golpear(madera);
		
		assertEquals(new BigDecimal(0), ((Madera)madera).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeDiamanteGolpeaPiedra_DeberiaReducirLaDurabilidaDelMaterialEn20() 
			throws Exception {
		
		Golpe golpeRompeDiamente = new GolpeRompeDiamante(new BigDecimal(20));
		Golpeable piedra = new Piedra();
		
		golpeRompeDiamente.golpear(piedra);
		
		assertEquals(new BigDecimal(10), ((Piedra)piedra).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeDiamanteGolpeaMetal_DeberiaReducirLaDurabilidaDelMaterialEn20() 
			throws Exception {
		
		Golpe golpeRompeDiamente = new GolpeRompeDiamante(new BigDecimal(20));
		Golpeable metal = new Metal();
		
		golpeRompeDiamente.golpear(metal);
		
		assertEquals(new BigDecimal(30), ((Metal)metal).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeDiamanteGolpeaDiamante_DeberiaReducirLaDurabilidaDelMaterialEn20() 
			throws Exception {
		
		Golpe golpeRompeDiamente = new GolpeRompeDiamante(new BigDecimal(20));
		Golpeable diamante = new Diamante();
		
		golpeRompeDiamente.golpear(diamante);
		
		assertEquals(new BigDecimal(80), ((Diamante)diamante).getDurabilidad());
	}
}
