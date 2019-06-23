package fiuba.algo3.tp2.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

public class PicoTest {

	/**************************
	 * PRUBAS PICO DE MADERA  *
	 **************************/
	@Test
	public void cuandoSeCreaUnPicoDeMadera_DeberiaTenerDurabilidad100YFuerza2() {
		
		Herramienta picoDeMadera = HerramientaFactory.newPicoDeMadera();
		
		assertEquals(new BigDecimal(100), picoDeMadera.getDurabilidad()); 
		assertEquals(new BigDecimal(2), picoDeMadera.getFuerza());
	}
	
	@Test 
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{
		
		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material madera = new Madera();
		BigDecimal durabilidad = pico.getDurabilidad();
		
		pico.golpear(madera);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material piedra = new Piedra();
		BigDecimal durabilidad = pico.getDurabilidad();
		
		pico.golpear(piedra);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));
	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material metal = new Metal();
		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(metal);
		
		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));

	}

	@Test
	public void dadoUnPicoDeMadera_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn2()
			throws Exception{

		Herramienta pico = HerramientaFactory.newPicoDeMadera();
		Material diamante = new Diamante();
		BigDecimal durabilidad = pico.getDurabilidad();

		pico.golpear(diamante);

		assertEquals(pico.getDurabilidad(), durabilidad.subtract(new BigDecimal(2)));

	}
	
	/**************************
	 * PRUBAS PICO DE PIEDRA  *
	 **************************/
	@Test
	public void cuandoSeCreaUnPicoDePiedra_DeberiaTenerDurabilidad200YFuerza4() {
		
		Herramienta picoDePiedra = HerramientaFactory.newPicoDePiedra();
		
		assertEquals(new BigDecimal(200), picoDePiedra.getDurabilidad()); 
		assertEquals(new BigDecimal(4), picoDePiedra.getFuerza());
	}

	@Test
	public void dadoUnPicoDePiedra_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn2Coma6()
			throws Exception{

		Herramienta picoDePiedra = HerramientaFactory.newPicoDePiedra();
		Material madera = new Madera();
		BigDecimal durabilidad = picoDePiedra.getDurabilidad();
		BigDecimal desgaste = picoDePiedra.getFuerza().divide(new BigDecimal(1.5), 2, RoundingMode.HALF_UP);

		picoDePiedra.golpear(madera);

		assertEquals(picoDePiedra.getDurabilidad(), durabilidad.subtract(desgaste));
	}

	@Test
	public void dadoUnPicoDePiedra_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn2Coma6()
			throws Exception{

		Herramienta picoDePiedra = HerramientaFactory.newPicoDePiedra();
		Material piedra = new Piedra();
		BigDecimal durabilidad = picoDePiedra.getDurabilidad();
		BigDecimal desgaste = picoDePiedra.getFuerza().divide(new BigDecimal(1.5), 2, RoundingMode.HALF_UP);

		picoDePiedra.golpear(piedra);

		assertEquals(picoDePiedra.getDurabilidad(), durabilidad.subtract(desgaste));
	}

	@Test
	public void dadoUnPicoDePiedra_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn2Coma6()
			throws Exception{

		Herramienta picoDePiedra = HerramientaFactory.newPicoDePiedra();
		Material metal = new Metal();
		BigDecimal durabilidad = picoDePiedra.getDurabilidad();
		BigDecimal desgaste = picoDePiedra.getFuerza().divide(new BigDecimal(1.5), 2, RoundingMode.HALF_UP);

		picoDePiedra.golpear(metal);

		assertEquals(picoDePiedra.getDurabilidad(), durabilidad.subtract(desgaste));
	}

	@Test
	public void dadoUnPicoDePiedra_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn2Coma6()
			throws Exception{

		Herramienta picoDePiedra = HerramientaFactory.newPicoDePiedra();
		Material diamante = new Diamante();
		BigDecimal durabilidad = picoDePiedra.getDurabilidad();
		BigDecimal desgaste = picoDePiedra.getFuerza().divide(new BigDecimal(1.5), 2, RoundingMode.HALF_UP);

		picoDePiedra.golpear(diamante);

		assertEquals(picoDePiedra.getDurabilidad(), durabilidad.subtract(desgaste));
	}

	/**************************
	 * PRUBAS PICO DE METAL   *
	 **************************/
	@Test
	public void cuandoSeCreaUnPicoDeMetal_DeberiaTenerDurabilidad400YFuerza12() {
		
		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		
		assertEquals(new BigDecimal(400), picoDeMetal.getDurabilidad()); 
		assertEquals(new BigDecimal(12), picoDeMetal.getFuerza());
	}

	@Test
	public void dadoUnPicoDeMetal_CuandoSeUsaUnaVezContraMadera_DeberiaDisminuirLaDurabilidadEn12()
			throws Exception{

		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		Material madera = new Madera();
		BigDecimal durabilidad = picoDeMetal.getDurabilidad();

		picoDeMetal.golpear(madera);

		assertEquals(picoDeMetal.getDurabilidad(), durabilidad);
	}

	@Test
	public void dadoUnPicoDeMetal_CuandoSeUsaUnaVezContraPiedra_DeberiaDisminuirLaDurabilidadEn12()
			throws Exception{

		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		Material piedra = new Piedra();
		BigDecimal durabilidad = picoDeMetal.getDurabilidad();

		picoDeMetal.golpear(piedra);

		assertEquals(picoDeMetal.getDurabilidad(), durabilidad);
	}

	@Test
	public void dadoUnPicoDeMetal_CuandoSeUsaUnaVezContraMetal_DeberiaDisminuirLaDurabilidadEn12()
			throws Exception{

		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		Material metal = new Metal();
		BigDecimal durabilidad = picoDeMetal.getDurabilidad();

		picoDeMetal.golpear(metal);

		assertEquals(picoDeMetal.getDurabilidad(), durabilidad);
	}

	@Test
	public void dadoUnPicoDeMetal_CuandoSeUsaUnaVezContraDiamante_DeberiaDisminuirLaDurabilidadEn12()
			throws Exception{

		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		Material diamante = new Diamante();
		BigDecimal durabilidad = picoDeMetal.getDurabilidad();

		picoDeMetal.golpear(diamante);

		assertEquals(picoDeMetal.getDurabilidad(), durabilidad);
	}

	@Test
	public void dadoUnPicoDeMetal_CuandoSeUsa10VecesContraMateriales_DeberiaRomperseYDisminuirLaDurabilidadA0()
			throws Exception{

		Herramienta picoDeMetal = HerramientaFactory.newPicoDeMetal();
		Material madera = new Madera();

		for(int i = 0; i < 10; i++)
			picoDeMetal.golpear(madera);

		assertEquals(picoDeMetal.getDurabilidad(), new BigDecimal(0));
	}
}