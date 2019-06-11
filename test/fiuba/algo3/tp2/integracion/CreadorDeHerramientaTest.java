package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.creador.CreadorHerramienta;
import fiuba.algo3.tp2.herramienta.creador.MaterialesMalPosicionadosException;
import fiuba.algo3.tp2.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.herramienta.creador.Tablero;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Vacio;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreadorDeHerramientaTest {

	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnHachaDeMadera_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMadera()
			throws Exception{
		Tablero tablero = new Tablero();

		tablero.setMaterial(new Madera(),1);
		tablero.setMaterial(new Madera(),2);
		tablero.setMaterial(new Vacio(), 3);
		tablero.setMaterial(new Madera(),4);
		tablero.setMaterial(new Madera(),5);
		tablero.setMaterial(new Vacio(), 6);
		tablero.setMaterial(new Vacio(), 7);
		tablero.setMaterial(new Madera(),8);
		tablero.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals( new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(2));
	}

	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnHachaDePiedra_ElCreadorDeHerramientasDeberiaCrearUnHachaDePiedra()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Tablero tablero = new Tablero();

		tablero.setMaterial(new Piedra(),1);
		tablero.setMaterial(new Piedra(),2);
		tablero.setMaterial(new Vacio(), 3);
		tablero.setMaterial(new Piedra(),4);
		tablero.setMaterial(new Madera(),5);
		tablero.setMaterial(new Vacio(), 6);
		tablero.setMaterial(new Vacio(), 7);
		tablero.setMaterial(new Madera(),8);
		tablero.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(5), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnHachaDeMetal_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMetal()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Tablero tablero = new Tablero();


		tablero.setMaterial(new Metal(),1);
		tablero.setMaterial(new Metal(),2);
		tablero.setMaterial(new Vacio(), 3);
		tablero.setMaterial(new Metal(),4);
		tablero.setMaterial(new Madera(),5);
		tablero.setMaterial(new Vacio(), 6);
		tablero.setMaterial(new Vacio(), 7);
		tablero.setMaterial(new Madera(),8);
		tablero.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(400));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(10));
	}

	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnPicoDeMadera_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDeMadera()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Tablero tablero = new Tablero();

		tablero.setMaterial(new Madera(),1);
		tablero.setMaterial(new Madera(),2);
		tablero.setMaterial(new Madera(), 3);
		tablero.setMaterial(new Vacio(),4);
		tablero.setMaterial(new Madera(),5);
		tablero.setMaterial(new Vacio(), 6);
		tablero.setMaterial(new Vacio(), 7);
		tablero.setMaterial(new Madera(),8);
		tablero.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		Herramienta herramienta = creador.crearHerramienta();


		Assert.assertEquals(new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(2), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnUnPicoDePiedra_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDePiedra()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Tablero tablero = new Tablero();

		tablero.setMaterial(new Piedra(),1);
		tablero.setMaterial(new Piedra(),2);
		tablero.setMaterial(new Piedra(), 3);
		tablero.setMaterial(new Vacio(),4);
		tablero.setMaterial(new Madera(),5);
		tablero.setMaterial(new Vacio(), 6);
		tablero.setMaterial(new Vacio(), 7);
		tablero.setMaterial(new Madera(),8);
		tablero.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(4), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnUnPicoDeMetal_ElCreadorDeHerramientasDeberiaCrearUnPicoDeMetal()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Tablero tablero = new Tablero();

		tablero.setMaterial(new Metal(),1);
		tablero.setMaterial(new Metal(),2);
		tablero.setMaterial(new Metal(), 3);
		tablero.setMaterial(new Vacio(),4);
		tablero.setMaterial(new Madera(),5);
		tablero.setMaterial(new Vacio(), 6);
		tablero.setMaterial(new Vacio(), 7);
		tablero.setMaterial(new Madera(),8);
		tablero.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(400), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(12), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnUnPicoFino_ElCreadorDeHerramientasDeberiaCrearUnPicoFino()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Tablero tablero = new Tablero();

		tablero.setMaterial(new Metal(),1);
		tablero.setMaterial(new Metal(),2);
		tablero.setMaterial(new Metal(), 3);
		tablero.setMaterial(new Piedra(),4);
		tablero.setMaterial(new Madera(),5);
		tablero.setMaterial(new Vacio(), 6);
		tablero.setMaterial(new Vacio(), 7);
		tablero.setMaterial(new Madera(),8);
		tablero.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(1000), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(20), herramienta.getFuerza());
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void cuandoAgreganLosMaterialesAlTableroEnUnaDisposicionIncorrecta_ElCreadorDeHerramientasDeberiaLanzarUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Tablero tablero = new Tablero();

		for (int i = 1; i < 10; i++) {
			tablero.setMaterial(new Metal(), i);
		}

		CreadorHerramienta creador = new CreadorHerramienta(tablero);
		creador.crearHerramienta();
	}
}
