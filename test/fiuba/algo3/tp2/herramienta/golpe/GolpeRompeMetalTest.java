package fiuba.algo3.tp2.herramienta.golpe;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

public class GolpeRompeMetalTest {
	
	@Test
	public void cuandoUnGolpeRompeMetalDeFuerza12GolpeaMadera_NoDeberiaReducirLaDurabilidaDelMaterial() 
			throws Exception {
		
		Golpe golpeRompeMetal = new GolpeRompeMetal(new BigDecimal(12));
		Golpeable madera = new Madera();
		
		golpeRompeMetal.golpear(madera);
		
		assertEquals(new BigDecimal(10), ((Madera)madera).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeMetalDeFuerza12GolpeaPiedra_DeberiaReducirLaDurabilidaDelMaterialEn12() 
			throws Exception {
		
		Golpe golpeRompeMetal = new GolpeRompeMetal(new BigDecimal(12));
		Golpeable piedra = new Piedra();
		
		golpeRompeMetal.golpear(piedra);
		
		assertEquals(new BigDecimal(18), ((Piedra)piedra).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeMetalDeFuerza12GolpeaMetal_DeberiaReducirLaDurabilidaDelMaterialEn12() 
			throws Exception {
		
		Golpe golpeRompeMetal = new GolpeRompeMetal(new BigDecimal(12));
		Golpeable metal = new Metal();
		
		golpeRompeMetal.golpear(metal);
		
		assertEquals(new BigDecimal(38), ((Metal)metal).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeMetalDeFuerza12GolpeaDiamante_NoDeberiaReducirLaDurabilidaDelMaterial() 
			throws Exception {
		
		Golpe golpeRompeMetal = new GolpeRompeMetal(new BigDecimal(12));
		Golpeable diamante = new Diamante();
		
		golpeRompeMetal.golpear(diamante);
		
		assertEquals(new BigDecimal(100), ((Diamante)diamante).getDurabilidad());
	}
	
}
