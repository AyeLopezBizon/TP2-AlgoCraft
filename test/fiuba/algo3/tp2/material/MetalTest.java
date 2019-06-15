package fiuba.algo3.tp2.material;

import static org.junit.Assert.assertEquals;/*
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
*/
import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import org.junit.Test;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeMetal;
import fiuba.algo3.tp2.herramienta.golpe.Golpeable;

import java.math.BigDecimal;

public class MetalTest {

	@Test
	public void cuandoSeCreaUnMetal_SuDurabilidadDebeSer50() {
		
		Metal metal = new Metal();
		
		assertEquals(new BigDecimal(50), metal.getDurabilidad());
	}
	/*
	@Test
	public void cuandoMetalEsGolpeadaConUnGolpeRompeMetal_DeberiaInvocarseElMetodoGolpearDelGolpe() 
			throws Exception {
		
		Golpeable metal = new Metal();
		Golpe golpe = mock(GolpeRompeMetal.class);
		
		metal.golpearCon(golpe);
		
		verify(golpe, times(1)).golpear((Metal)metal);
	}
*/
	@Test
	public void cuandoSeGolpeaMetalConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material metal = new Metal();

		hachaMadera.golpear(metal);

		assertEquals(new BigDecimal(50), metal.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMetalConHachaDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial() throws Exception {

		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material metal = new Metal();

		hachaPiedra.golpear(metal);

		assertEquals(new BigDecimal(50), metal.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMetalConHachaDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial() throws Exception {

		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material metal = new Metal();

		hachaMetal.golpear(metal);

		assertEquals(new BigDecimal(50), metal.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMetalConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material metal = new Metal();

		picoMadera.golpear(metal);

		assertEquals(new BigDecimal(50), metal.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMetalConPicoDePiedra_DeberiaReducirLaDurabilidadDelMaterialEn4()
			throws Exception {

		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material metal = new Metal();

		picoPiedra.golpear(metal);

		assertEquals(new BigDecimal(46), metal.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMetalConPicoDeMetal_DeberiaReducirLaDurabilidadDelMaterialEn12()
			throws Exception {

		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material metal = new Metal();

		picoMetal.golpear(metal);

		assertEquals(new BigDecimal(38), metal.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMetalConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20()
			throws Exception {

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material metal = new Metal();

		picoFino.golpear(metal);

		assertEquals(new BigDecimal(30), metal.getDurabilidad());
	}
}
