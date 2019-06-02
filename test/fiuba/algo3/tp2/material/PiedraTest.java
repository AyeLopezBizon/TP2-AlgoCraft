package fiuba.algo3.tp2.material;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeMadera;

import java.math.BigDecimal;

public class PiedraTest {

	@Test
	public void cuandoSeCreaUnaPiedra_SuDurabilidadDebeSer30() {
		
		Piedra piedra = new Piedra();
		
		assertEquals(new BigDecimal(30), piedra.getDurabilidad());
	}
	
	@Test
	public void cuandoPiedraEsGolpeadaConUnGolpeRompePiedra_DeberiaInvocarseElMetodoGolpearDelGolpe() 
			throws Exception {
		
		Golpeable piedra = new Piedra();
		Golpe golpe = mock(GolpeRompeMadera.class);
		
		piedra.golpearCon(golpe);
		
		verify(golpe, times(1)).golpear((Piedra)piedra);
	}
}
