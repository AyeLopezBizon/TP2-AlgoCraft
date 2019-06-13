/*package fiuba.algo3.tp2.material;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import org.junit.Test;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeMadera;

import java.math.BigDecimal;

public class MaderaTest {

	@Test
	public void cuandoSeCreaUnaMadera_SuDurabilidadDebeSer10() {
		
		Madera madera = new Madera();
		
		assertEquals(new BigDecimal(10), madera.getDurabilidad());
	}
	
	@Test
	public void cuandoMaderaEsGolpeadaConUnGolpeRompeMadera_DeberiaInvocarseElMetodoGolpearDelGolpe() 
			throws Exception {
		
		Madera madera = new Madera();
		Golpe golpe = mock(GolpeRompeMadera.class);
		
		madera.golpearCon(golpe);
		
		verify(golpe, times(1)).golpear(madera);
	}

	@Test
	public void cuandoSeGolpeaMaderaConHachaDeMadera_DeberiaReducirLaDurabilidadDeLaMaderaEn2()
			throws Exception {

		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material madera = new Madera();

		hachaMadera.golpear(madera);

		assertEquals(new BigDecimal(8), madera.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMaderaConHachaDePiedra_DeberiaReducirLaDurabilidadDeLaMaderaEn5()
			throws Exception {

		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material madera = new Madera();

		hachaPiedra.golpear(madera);

		assertEquals(new BigDecimal(5), madera.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMaderaConHachaDeMetal_DeberiaReducirLaDurabilidadDeLaMaderaEn10()
			throws Exception {

		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material madera = new Madera();

		hachaMetal.golpear(madera);

		assertEquals(new BigDecimal(0), madera.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMaderaConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material madera = new Madera();

		picoMadera.golpear(madera);

		assertEquals(new BigDecimal(10), madera.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMaderaConPicoDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material madera = new Madera();

		picoPiedra.golpear(madera);

		assertEquals(new BigDecimal(10), madera.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMaderaConPicoDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material madera = new Madera();

		picoMetal.golpear(madera);

		assertEquals(new BigDecimal(10), madera.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaMaderaConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20()
			throws Exception {

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material madera = new Madera();

		picoFino.golpear(madera);

		assertEquals(new BigDecimal(0), madera.getDurabilidad());
	}

	//@Test
	//public void dadaUnaMaderaDestruida_CuandoSeGolpeaConUnGolpeRompeMadera_DeberiaLanzarMaterialDestruidoNoSePuedeGolpearException() {
		
	//	Golpeable madera = new Madera();
	//	Golpe golpeRompeMadera = mock(GolpeRompeMadera.class);

	//	try {
	//		hachaMadera.golpear(madera);
	//		fail("Deberia lanzar MaterialDestruidoNoSePuedeGolpearException");
	//	} catch(Exception exception) {
	//		assertEquals(MaterialDestruidoNoSePuedeGolpearException.class, exception.getClass());
	//	}
	//}

}*/
