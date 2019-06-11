package fiuba.algo3.tp2.herramienta.creador;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;

public class CreadorHerramientaTest {
	
	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConTableroVacio_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		Tablero tablero = new Tablero();
		CreadorHerramienta creador = new CreadorHerramienta(tablero);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConTableroConUnElemento_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		Tablero tablero = new Tablero();
		CreadorHerramienta creador = new CreadorHerramienta(tablero);

		tablero.setMaterial(new Madera(), 1);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConTableroConDosElementos_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		Tablero tablero = new Tablero();
		CreadorHerramienta creador = new CreadorHerramienta(tablero);

		tablero.setMaterial(new Madera(), 1);
		tablero.setMaterial(new Madera(), 9);

		creador.crearHerramienta();
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void dadoUnCreadorConTableroNoVacio_CrearHerramientaDevuelveUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {

		Tablero tablero = new Tablero();
		CreadorHerramienta creador = new CreadorHerramienta(tablero);

		for(int i = 1; i < 10; i++) {
			tablero.setMaterial(new Madera(), i);
		}

		creador.crearHerramienta();
	}
}
