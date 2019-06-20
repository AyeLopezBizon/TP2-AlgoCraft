package fiuba.algo3.tp2.modelo.herramienta.golpe;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

public class GolpeRompePiedraTest {

	@Test
	public void cuandoUnGolpeRompePiedraDeFuerza2GolpeaMadera_NoDeberiaReducirLaDurabilidaDelMaterial() 
			throws Exception {
		
		Golpe golpeRompePiedra = new GolpeRompePiedra(new BigDecimal(2));
		Golpeable madera = new Madera();
		
		golpeRompePiedra.golpear(madera);
		
		assertEquals(new BigDecimal(10), ((Madera)madera).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompePiedraDeFuerza2GolpeaPiedra_DeberiaReducirLaDurabilidaDelMaterialEn2() 
			throws Exception {
		
		Golpe golpeRompePiedra = new GolpeRompePiedra(new BigDecimal(2));
		Golpeable piedra = new Piedra();
		
		golpeRompePiedra.golpear(piedra);
		
		assertEquals(new BigDecimal(28), ((Piedra)piedra).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompePiedraDeFuerza5GolpeaPiedra_DeberiaReducirLaDurabilidaDelMaterialEn5() 
			throws Exception {
		
		Golpe golpeRompePiedra = new GolpeRompePiedra(new BigDecimal(5));
		Golpeable piedra = new Piedra();
		
		golpeRompePiedra.golpear(piedra);
		
		assertEquals(new BigDecimal(25), ((Piedra)piedra).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompePiedraDeFuerza5GolpeaMetal_NoDeberiaReducirLaDurabilidaDelMaterial() 
			throws Exception {
		
		Golpe golpeRompePiedra = new GolpeRompePiedra(new BigDecimal(5));
		Golpeable metal = new Metal();
		
		golpeRompePiedra.golpear(metal);
		
		assertEquals(new BigDecimal(50), ((Metal)metal).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompePiedraDeFuerza5GolpeaDiamante_NoDeberiaReducirLaDurabilidaDelMaterial() 
			throws Exception {
		
		Golpe golpeRompePiedra = new GolpeRompePiedra(new BigDecimal(5));
		Golpeable diamante = new Diamante();
		
		golpeRompePiedra.golpear(diamante);
		
		assertEquals(new BigDecimal(100), ((Diamante)diamante).getDurabilidad());
	}
}
