package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.material.*;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class MesaDeTrabajoTest {

	@Test
	public void cuandoSeConstruyeUnaMesaDeTrabajo_DeberiaTenerTodasLasCasillasVacias() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		
		for(int i=1; i<10; i++) {
			Assert.assertEquals(new BigDecimal(0), mesaDeTrabajo.getCasilla(i).getDurabilidad());	
		}	
	}
	
	@Test
	public void cuandoSeAgregaUnMaterialALaMesaDeTrabajo_DeberiaAlmacenarloCorrectamente() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		Material material = new Metal();
		mesaDeTrabajo.setMaterial(material, 1);
		Assert.assertEquals(material.getDurabilidad(), mesaDeTrabajo.getCasilla(1).getDurabilidad());
	}
	
	@Test
	public void cuandoSeComparaConOtraMesaDeTrabajoIgual_DeberiaDevolverTrue() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo1 = new MesaDeTrabajoVacia();
		MesaDeTrabajo mesaDeTrabajo2 = new MesaDeTrabajoVacia();
		
		mesaDeTrabajo1.setMaterial(new Madera(), 2);
		mesaDeTrabajo2.setMaterial(new Madera(), 2);
		
		Assert.assertTrue(mesaDeTrabajo1.comparar(mesaDeTrabajo2));
	}
	
	@Test
	public void cuandoSeComparaConOtraMesaDeTrabajoDistinta_DeberiaDevolverFalse() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo1 = new MesaDeTrabajoVacia();
		MesaDeTrabajo mesaDeTrabajo2 = new MesaDeTrabajoVacia();
		
		mesaDeTrabajo1.setMaterial(new Madera(), 3);
		mesaDeTrabajo2.setMaterial(new Madera(), 2);
		
		Assert.assertFalse(mesaDeTrabajo1.comparar(mesaDeTrabajo2));
	}

	@Test(expected = PosicionIncorrectaException.class)
	public void cuandoSeAlmacenaEnUnaPosiconIncorrectaEnUnaMesaDeTrabajo_DeberiaLanzarUnaExcepcion() 
			throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		mesaDeTrabajo.setMaterial(new Madera(), 20);
	}
	
}
