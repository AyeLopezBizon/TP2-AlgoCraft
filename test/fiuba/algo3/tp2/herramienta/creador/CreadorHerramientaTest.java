package fiuba.algo3.tp2.herramienta.creador;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;

public class CreadorHerramientaTest {
	
	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConUnElemento_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();
		
		mesaDeTrabajo.setMaterial(new Madera(), 1);
		
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConDosElementos_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.setMaterial(new Madera(), 1);
		mesaDeTrabajo.setMaterial(new Madera(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoNoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		for(int i = 1; i < 10; i++) {
			mesaDeTrabajo.setMaterial(new Madera(), i);
		}
		
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}
}
