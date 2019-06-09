package fiuba.algo3.tp2.herramienta.durabilidad;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class DurabilidadRupturaAbruptaTest {

	@Test
	public void cuandoSeCreaUnaDurabilidadRupturaAbruptaConDurabilidadInicial100_AlObtenerLaDurabilidad_DeberiaDevolver100() {
		
		Durabilidad durabilidadAbrupta = new DurabilidadRupturaAbrupta(new BigDecimal(100), 10);
		
		assertEquals(new BigDecimal(100), durabilidadAbrupta.getValor());
	}
	
	@Test
	public void cuandoSeCreaUnaDurabilidadRupturaAbruptaConDurabilidadInicial100_CuandoSeReduce1Vez_NoDeberiaReducirSuDurabilidad()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadAbrupta = new DurabilidadRupturaAbrupta(new BigDecimal(100), 10);
		
		durabilidadAbrupta.reducir();
		
		assertEquals(new BigDecimal(100), durabilidadAbrupta.getValor());
	}
	
	@Test
	public void cuandoSeCreaUnaDurabilidadRupturaAbruptaConDurabilidadInicial100_CuandoSeReduce9Veces_NoDeberiaReducirSuDurabilidad()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadAbrupta = new DurabilidadRupturaAbrupta(new BigDecimal(100), 10);
		
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		
		assertEquals(new BigDecimal(100), durabilidadAbrupta.getValor());
	}
	
	@Test
	public void cuandoSeCreaUnaDurabilidadRupturaAbruptaConDurabilidadInicial100QueYaFueReducida9Veces_CuandoSeReduce1VezMas_DeberiaReducirSuDurabilidadA0()
			throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		Durabilidad durabilidadAbrupta = new DurabilidadRupturaAbrupta(new BigDecimal(100), 10);
		
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		durabilidadAbrupta.reducir();
		
		durabilidadAbrupta.reducir();
		
		assertEquals(new BigDecimal(0), durabilidadAbrupta.getValor());
	}
}