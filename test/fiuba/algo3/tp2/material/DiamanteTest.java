package fiuba.algo3.tp2.material;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeDiamante;

import java.math.BigDecimal;

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
}
