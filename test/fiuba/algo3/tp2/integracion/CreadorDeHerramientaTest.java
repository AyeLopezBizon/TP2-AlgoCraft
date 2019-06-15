package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.creador.*;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Vacio;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreadorDeHerramientaTest {

	@Test
	public void cuandoAgreganLosMaterialesAlaMesaDeTrabajoParaConstruirUnHachaDeMadera_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMadera()
			throws Exception{
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals( new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(2));
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnHachaDePiedra_ElCreadorDeHerramientasDeberiaCrearUnHachaDePiedra()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new Piedra(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Piedra(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Piedra(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(5), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnHachaDeMetal_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMetal()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();


		mesaDeTrabajo.agregarMaterial(new Metal(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Metal(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Metal(), new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(400));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(10));
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnPicoDeMadera_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDeMadera()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Madera(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();


		Assert.assertEquals(new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(2), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoDePiedra_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDePiedra()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new Piedra(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Piedra(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Piedra(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(4), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoDeMetal_ElCreadorDeHerramientasDeberiaCrearUnPicoDeMetal()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new Metal(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Metal(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Metal(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(400), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(12), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoFino_ElCreadorDeHerramientasDeberiaCrearUnPicoFino()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new Metal(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Metal(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Metal(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Piedra(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new Vacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(1000), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(20), herramienta.getFuerza());
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoEnUnaDisposicionIncorrecta_ElCreadorDeHerramientasDeberiaLanzarUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException,
			CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				mesaDeTrabajo.agregarMaterial(new Metal(), new Posicion(i,j));
			}
		}

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}
}
