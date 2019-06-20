package fiuba.algo3.tp2.modelo.material;

import static org.junit.Assert.assertEquals;/*
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
*/

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaFactory;

public class PiedraTest {

	@Test
	public void cuandoSeCreaUnaPiedra_SuDurabilidadDebeSer30() {
		
		Piedra piedra = new Piedra();
		
		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}
/*
	@Test
	public void cuandoPiedraEsGolpeadaConUnGolpeRompePiedra_DeberiaInvocarseElMetodoGolpearDelGolpe() 
			throws Exception {
		
		Golpeable piedra = new Piedra();
		Golpe golpe = mock(GolpeRompeMadera.class);
		
		piedra.golpearCon(golpe);
		
		verify(golpe, times(1)).golpear((Piedra)piedra);
	}
*/
	@Test
	public void cuandoSeGolpeaPiedraConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material piedra = new Piedra();

		hachaMadera.golpear(piedra);

		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaPiedraConHachaDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material piedra = new Piedra();

		hachaPiedra.golpear(piedra);

		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaPiedraConHachaDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material piedra = new Piedra();

		hachaMetal.golpear(piedra);

		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaPiedraConPicoDeMadera_DeberiaReducirLaDurabilidadDeLaPiedraEn2()
			throws Exception {

		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material piedra = new Piedra();

		picoMadera.golpear(piedra);

		assertEquals(new BigDecimal(28), piedra.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaPiedraConPicoDePiedra_DeberiaReducirLaDurabilidadDeLaPiedraEn4()
			throws Exception {

		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material piedra = new Piedra();

		picoPiedra.golpear(piedra);

		assertEquals(new BigDecimal(26), piedra.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaPiedraConPicoDeMetal_DeberiaReducirLaDurabilidadDeLaPiedraEn12()
			throws Exception {

		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material piedra = new Piedra();

		picoMetal.golpear(piedra);

		assertEquals(new BigDecimal(18), piedra.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaPiedraConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20()
			throws Exception {

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material piedra = new Piedra();

		picoFino.golpear(piedra);

		assertEquals(new BigDecimal(10), piedra.getDurabilidad());
	}
}
