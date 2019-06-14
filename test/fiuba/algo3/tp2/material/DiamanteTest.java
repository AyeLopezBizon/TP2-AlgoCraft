package fiuba.algo3.tp2.material;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeDiamante;
import fiuba.algo3.tp2.herramienta.golpe.Golpeable;

public class DiamanteTest {
	
	@Test
	public void cuandoSeCreaUnDiamante_SuDurabilidadDebeSer100() {
		
		Diamante diamante = new Diamante();
		
		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}
	
	@Test
	public void cuandoDiamanteEsGolpeadaConUnGolpeRompeDiamante_DeberiaInvocarseElMetodoGolpearDelGolpe() 
			throws Exception {
		
		Golpeable diamante = new Diamante();
		Golpe golpe = mock(GolpeRompeDiamante.class);
		
		diamante.golpearCon(golpe);
		
		verify(golpe, times(1)).golpear((Diamante)diamante);
	}

	@Test
	public void cuandoSeGolpeaDiamanteConHachaDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta hachaMadera = HerramientaFactory.newHachaDeMadera();
		Material diamante = new Diamante();

		hachaMadera.golpear(diamante);

		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaDiamanteConHachaDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta hachaPiedra = HerramientaFactory.newHachaDePiedra();
		Material diamante = new Diamante();

		hachaPiedra.golpear(diamante);

		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaDiamanteConHachaDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta hachaMetal = HerramientaFactory.newHachaDeMetal();
		Material diamante = new Diamante();

		hachaMetal.golpear(diamante);

		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaDiamanteConPicoDeMadera_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta picoMadera = HerramientaFactory.newPicoDeMadera();
		Material diamante = new Diamante();

		picoMadera.golpear(diamante);

		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaDiamanteConPicoDePiedra_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta picoPiedra = HerramientaFactory.newPicoDePiedra();
		Material diamante = new Diamante();

		picoPiedra.golpear(diamante);

		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaDiamanteConPicoDeMetal_NoSeDeberiaReducirLaDurabilidadDelMaterial()
			throws Exception {

		Herramienta picoMetal = HerramientaFactory.newPicoDeMetal();
		Material diamante = new Diamante();

		picoMetal.golpear(diamante);

		assertEquals(new BigDecimal(100), diamante.getDurabilidad());
	}

	@Test
	public void cuandoSeGolpeaDiamanteConPicoFino_DeberiaReducirLaDurabilidadDelMaterialEn20()
			throws Exception {

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material diamante = new Diamante();

		picoFino.golpear(diamante);

		assertEquals(new BigDecimal(80), diamante.getDurabilidad());
	}

}
