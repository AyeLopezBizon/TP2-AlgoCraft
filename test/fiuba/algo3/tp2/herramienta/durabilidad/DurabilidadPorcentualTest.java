package fiuba.algo3.tp2.herramienta.durabilidad;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class DurabilidadPorcentualTest {
	
	@Test
	public void cuandoSeCreaUnaDurabilidadPorcentualConDurabilidadInicial1000_AlObtenerLaDurabilidad_DeberiaDevolver1000() {
		
		Durabilidad durabilidadPorcentual = new DurabilidadPorcentual(new BigDecimal(1000), new BigDecimal(10));
		
		assertEquals(new BigDecimal(1000), durabilidadPorcentual.getValor());
	}
	
	@Test
	public void dadaUnaDurabilidadPorcentualConDurabilidadInicial1000_CuandoSeReduce1Vez_DeberiaReducirSuDurabilidadEn100()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadPorcentual = new DurabilidadPorcentual(new BigDecimal(1000), new BigDecimal(10));
		
		durabilidadPorcentual.reducir();
		
		assertEquals(new BigDecimal(900), durabilidadPorcentual.getValor());
	}

	@Test
	public void dadaUnaDurabilidadPorcentualConDurabilidadInicial1000_SuDurabilidadLuegoDeReducir3VecesDeberiaSer729()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadPorcentual = new DurabilidadPorcentual(new BigDecimal(1000), new BigDecimal(10));
		
		durabilidadPorcentual.reducir();
		durabilidadPorcentual.reducir();
		durabilidadPorcentual.reducir();
		
		assertEquals(new BigDecimal(729), durabilidadPorcentual.getValor());
	}
}