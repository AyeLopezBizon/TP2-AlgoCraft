package fiuba.algo3.tp2.modelo.herramienta.golpe;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

public class GolpeRompeMaderaTest {

	@Test
	public void cuandoUnGolpeRompeMaderaDeFuerza2GolpeaMadera_DeberiaReducirLaDurabilidaDelMaterialEn2() 
			throws Exception {
		
		Golpe golpeRompeMadera = new GolpeRompeMadera(new BigDecimal(2));
		Golpeable madera = new Madera();
		
		golpeRompeMadera.golpear(madera);
		
		assertEquals(new BigDecimal(8), ((Madera)madera).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeMaderaDeFuerza5GolpeaMadera_DeberiaReducirLaDurabilidaDelMaterialEn5() 
			throws Exception {
		
		Golpe golpeRompeMadera = new GolpeRompeMadera(new BigDecimal(5));
		Golpeable madera = new Madera();
		
		golpeRompeMadera.golpear(madera);
		
		assertEquals(new BigDecimal(5), ((Madera)madera).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeMaderaDeFuerza2GolpeaPiedra_NoDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Golpe golpeRompeMadera = new GolpeRompeMadera(new BigDecimal(2));
		Golpeable piedra = new Piedra();
		
		golpeRompeMadera.golpear(piedra);
		
		assertEquals(new BigDecimal(30), ((Piedra)piedra).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeMaderaDeFuerza2GolpeaMetal_NoDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Golpe golpeRompeMadera = new GolpeRompeMadera(new BigDecimal(2));
		Golpeable metal = new Metal();
		
		golpeRompeMadera.golpear(metal);
		
		assertEquals(new BigDecimal(50), ((Metal)metal).getDurabilidad());
	}
	
	@Test
	public void cuandoUnGolpeRompeMaderaDeFuerza2GolpeaDiamante_NoDeberiaReducirLaDurabilidadDelMaterial() 
			throws Exception {
		
		Golpe golpeRompeMadera = new GolpeRompeMadera(new BigDecimal(2));
		Golpeable diamante = new Diamante();
		
		golpeRompeMadera.golpear(diamante);
		
		assertEquals(new BigDecimal(100), ((Diamante)diamante).getDurabilidad());
	}
}
