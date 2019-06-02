package fiuba.algo3.tp2.material;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

}
