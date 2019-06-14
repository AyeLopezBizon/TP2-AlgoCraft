package fiuba.algo3.tp2.herramienta.creador;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;

public class CreadorHerramientaTest {
	
	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConUnElemento_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);

		mesaDeTrabajo.setMaterial(new Madera(), 1);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConDosElementos_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);

		mesaDeTrabajo.setMaterial(new Madera(), 1);
		mesaDeTrabajo.setMaterial(new Madera(), 9);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoNoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);

		for(int i = 1; i < 10; i++) {
			mesaDeTrabajo.setMaterial(new Madera(), i);
		}

		creador.crearHerramienta();
	}
}
