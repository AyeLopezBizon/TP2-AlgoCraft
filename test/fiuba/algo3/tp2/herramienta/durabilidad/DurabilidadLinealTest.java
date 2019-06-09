package fiuba.algo3.tp2.herramienta.durabilidad;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class DurabilidadLinealTest {

	@Test
	public void cuandoSeCreaUnaDurabilidadLinealConDurabilidadInicial100_AlObtenerLaDurabilidad_DeberiaDevolver100() {
		
		Durabilidad durabilidadLineal = new DurabilidadLineal(new BigDecimal(100), new BigDecimal(2));
		
		assertEquals(new BigDecimal(100), durabilidadLineal.getValor());
	}
	
	@Test
	public void dadaUnaDurabilidadLinealConDurabilidadInicial100YTasaDesgaste2_CuandoSeReduce_DeberiaReducirSuDurabilidadEn2()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadLineal = new DurabilidadLineal(new BigDecimal(100), new BigDecimal(2));
		durabilidadLineal.reducir();
		
		assertEquals(new BigDecimal(98), durabilidadLineal.getValor());
	}
	
	@Test
	public void dadaUnaDurabilidadLinealConDurabilidadInicial100YTasaDesgaste2_CuandoSeReduce3Veces_DeberiaReducirSuDurabilidadEn6()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadLineal = new DurabilidadLineal(new BigDecimal(100), new BigDecimal(2));
		durabilidadLineal.reducir();
		durabilidadLineal.reducir();
		durabilidadLineal.reducir();
		
		assertEquals(new BigDecimal(94), durabilidadLineal.getValor());
	}
	
	@Test
	public void dadaUnaDurabilidadLinealConDurabilidadInicial200YTasaDesgaste5_CuandoSeReduce_DeberiaReducirSuDurabilidadEn5()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadLineal = new DurabilidadLineal(new BigDecimal(200), new BigDecimal(5));
		durabilidadLineal.reducir();
		
		assertEquals(new BigDecimal(195), durabilidadLineal.getValor());
	}
	
	@Test
	public void dadaUnaDurabilidadLinealConDurabilidadInicial200YTasaDesgaste5_CuandoSeReduce3Veces_DeberiaReducirSuDurabilidadEn15()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadLineal = new DurabilidadLineal(new BigDecimal(200), new BigDecimal(5));
		durabilidadLineal.reducir();
		durabilidadLineal.reducir();
		durabilidadLineal.reducir();
		
		assertEquals(new BigDecimal(185), durabilidadLineal.getValor());
	}
}