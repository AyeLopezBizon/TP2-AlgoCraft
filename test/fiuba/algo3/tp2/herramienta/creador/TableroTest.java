package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.material.*;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

	@Test
	public void cuandoSeConstruyeUnTablero_DeberiaTenerTodasLasCasillasVacias() {
		Tablero tablero = new Tablero();
		
		for(int i=1; i<10; i++) {
			Assert.assertEquals(new BigDecimal(0), tablero.getCasilla(i).getDurabilidad());	
		}	
	}
	
	@Test
	public void cuandoSeAgregaUnMaterialAlTablero_DeberiaAlmacenarloCorrectamente() {
		Tablero tablero = new Tablero();
		Material material = new Metal();
		tablero.setMaterial(material, 1);
		Assert.assertEquals(material.getDurabilidad(), tablero.getCasilla(1).getDurabilidad());
	}
	
	@Test
	public void cuandoSeComparaConOtroTableroIgual_DeberiaDevolverTrue() {
		Tablero tablero1 = new Tablero();
		Tablero tablero2 = new Tablero();
		
		tablero1.setMaterial(new Madera(), 2);
		tablero2.setMaterial(new Madera(), 2);
		
		Assert.assertTrue(tablero1.comparar(tablero2));
	}
	
	@Test
	public void cuandoSeComparaConOtroTableroDistinto_DeberiaDevolverFalse() {
		Tablero tablero1 = new Tablero();
		Tablero tablero2 = new Tablero();
		
		tablero1.setMaterial(new Madera(), 3);
		tablero2.setMaterial(new Madera(), 2);
		
		Assert.assertFalse(tablero1.comparar(tablero2));
	}
/*
	@Test
	public void cuandoSeAlmacenaEnUnaPosiconIncorrecta_DeberiaLanzarUnaExcepcion() {
		
	}
	*/
}
