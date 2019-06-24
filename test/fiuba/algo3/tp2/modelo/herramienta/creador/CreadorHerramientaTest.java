package fiuba.algo3.tp2.modelo.herramienta.creador;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMadera;

public class CreadorHerramientaTest {
	
	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws Exception {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		CreadorHerramienta creador = new CreadorHerramienta();

		creador.crearHerramienta(mesaDeTrabajo);
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConUnElemento_CrearHerramientaDevuelveUnaExcepcion()
			throws Exception {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();
		
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(), new Posicion(new Integer(1), new Integer(1)));
		
		CreadorHerramienta creador = new CreadorHerramienta();
		creador.crearHerramienta(mesaDeTrabajo);
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConDosElementos_CrearHerramientaDevuelveUnaExcepcion()
			throws Exception {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new UnidadMadera(), new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(), new Posicion(new Integer(1), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		creador.crearHerramienta(mesaDeTrabajo);
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoNoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws Exception {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		for(int i = 1; i < 4; i++) {
			for(int j = 1; j<4; j++) {
				mesaDeTrabajo.agregarMaterial(new UnidadMadera(), new Posicion(new Integer(i), new Integer(j)));
			}
			
		}
		
		CreadorHerramienta creador = new CreadorHerramienta();
		creador.crearHerramienta(mesaDeTrabajo);
	}
}
