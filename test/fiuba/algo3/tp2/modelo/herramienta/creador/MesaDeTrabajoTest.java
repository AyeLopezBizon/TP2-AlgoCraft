package fiuba.algo3.tp2.modelo.herramienta.creador;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMadera;

public class MesaDeTrabajoTest {
/*
	@Test
	public void cuandoSeConstruyeUnaMesaDeTrabajo_DeberiaTenerTodasLasCasillasVacias() 
			throws PosicionIncorrectaException, CasilleroNoEncontradoException, CasilleroOcupadoException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		
		for(int i=1; i<4; i++) {
			for(int j=1; j<4; j++) {
				Assert.assertEquals(new Vacio().getDurabilidad(), mesaDeTrabajo.getCasilla(new Posicion(i,j)).getDurabilidad());	
			}
		}	
	}
	
	@Test
	public void cuandoSeAgregaUnMaterialALaMesaDeTrabajo_DeberiaAlmacenarloCorrectamente() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		Material material = new Metal();
		Posicion posicion = new Posicion(new Integer(1), new Integer(1));
		mesaDeTrabajo.setMaterial(material, posicion);
		Assert.assertEquals(material.getDurabilidad(), mesaDeTrabajo.getCasilla(posicion).getDurabilidad());
	}
	*/
	@Test
	public void cuandoSeComparaConOtraMesaDeTrabajoIgual_DeberiaDevolverTrue()
			throws Exception {
		MesaDeTrabajo mesaDeTrabajo1 = new MesaDeTrabajoVacia();
		MesaDeTrabajo mesaDeTrabajo2 = new MesaDeTrabajoVacia();
		Posicion posicion = new Posicion(new Integer(1), new Integer(1));
		mesaDeTrabajo1.agregarMaterial(new UnidadMadera(), posicion);
		mesaDeTrabajo2.agregarMaterial(new UnidadMadera(), posicion);
		
		assertTrue(mesaDeTrabajo1.comparar(mesaDeTrabajo2));
	}
	
	@Test
	public void cuandoSeComparaConOtraMesaDeTrabajoDistinta_DeberiaDevolverFalse()
			throws Exception {
		MesaDeTrabajo mesaDeTrabajo1 = new MesaDeTrabajoVacia();
		MesaDeTrabajo mesaDeTrabajo2 = new MesaDeTrabajoVacia();
		Posicion posicion1 = new Posicion(new Integer(1), new Integer(1));
		Posicion posicion2 = new Posicion(new Integer(2), new Integer(1));
		
		mesaDeTrabajo1.agregarMaterial(new UnidadMadera(), posicion1);
		mesaDeTrabajo2.agregarMaterial(new UnidadMadera(), posicion2);
		
		Assert.assertFalse(mesaDeTrabajo1.comparar(mesaDeTrabajo2));
	}

	@Test(expected = PosicionIncorrectaException.class)
	public void cuandoSeAlmacenaEnUnaPosiconIncorrectaEnUnaMesaDeTrabajo_DeberiaLanzarUnaExcepcion() 
			throws Exception {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		Posicion posicion = new Posicion(new Integer(100), new Integer(1));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(), posicion);
	}

	@Test
	public void dadaUnaMesaDeTrabajoConMaderas_AlLimpiarLaMesa_DeberiaEstarVacia()
			throws Exception {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();

		for(int i = 1; i <= 3; i++){
			for(int j = 1; j <= 3; j++){
				Posicion posicion = new Posicion(new Integer(i), new Integer(j));
				mesaDeTrabajo.agregarMaterial(new UnidadMadera(), posicion);
			}
		}

		mesaDeTrabajo.limpiarMesaDeTrabajo();

		MesaDeTrabajo mesaDeTrabajoVacia = new MesaDeTrabajoVacia();

		assertTrue(mesaDeTrabajo.comparar(mesaDeTrabajoVacia));

	}
}
