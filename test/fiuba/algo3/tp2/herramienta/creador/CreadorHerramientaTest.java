package fiuba.algo3.tp2.herramienta.creador;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class CreadorHerramientaTest {
	
	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException {

		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConUnElemento_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();
		
		mesaDeTrabajo.setMaterial(new Madera(), new Posicion(new Integer(1), new Integer(1)));
		
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoConDosElementos_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.setMaterial(new Madera(), new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.setMaterial(new Madera(), new Posicion(new Integer(1), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConMesaDeTrabajoNoVacia_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException {

		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		for(int i = 1; i < 4; i++) {
			for(int j = 1; j<4; j++) {
				mesaDeTrabajo.setMaterial(new Madera(), new Posicion(new Integer(i), new Integer(j)));	
			}
			
		}
		
		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}
}
