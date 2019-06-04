package fiuba.algo3.tp2.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Diamante;

import java.math.BigDecimal;

public class PicoFinoTest {
	
	/**************************
	 *    PRUBAS PICO FINO    *
	 **************************/

	@Test
	public void cuandoSeCreaPicoFino_DeberiaTenerDurabilidad1000YFuerza20() {
		
		Herramienta picoFino = HerramientaFactory.newPicoFino();
		
		assertEquals(picoFino.getDurabilidad(), new BigDecimal(1000));
		assertEquals(picoFino.getFuerza(), new BigDecimal(20));
	}

	@Test
	public void dadoUnPicoFino_CuandoSeUsaUnaVezContraMadera_NoDeberiaDisminuirLaDurabilidad()
			throws Exception {

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material madera = new Madera();

		BigDecimal durabilidad = picoFino.getDurabilidad();

		picoFino.golpear(madera);

		assertEquals(durabilidad, picoFino.getDurabilidad());
	}

	@Test
	public void dadoUnPicoFino_CuandoSeUsaUnaVezContraPiedra_NoDeberiaDisminuirLaDurabilidad() throws Exception{

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material piedra = new Piedra();

		BigDecimal durabilidad = picoFino.getDurabilidad();

		picoFino.golpear(piedra);

		assertEquals(durabilidad, picoFino.getDurabilidad());
	}

	@Test
	public void dadoUnPicoFino_CuandoSeUsaUnaVezContraMetal_NoDeberiaDismiuirLaDurabilidad() throws Exception{

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material metal = new Metal();

		BigDecimal durabilidad = picoFino.getDurabilidad();

		picoFino.golpear(metal);

		assertEquals(durabilidad, picoFino.getDurabilidad());
	}

	@Test
	public void dadoUnPicoFino_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn100() throws Exception{

		Herramienta picoFino = HerramientaFactory.newPicoFino();
		Material diamante = new Diamante();

		BigDecimal durabilidad = picoFino.getDurabilidad();

		picoFino.golpear(diamante);

		assertEquals(durabilidad.subtract(new BigDecimal(100)), picoFino.getDurabilidad());
	}
}
