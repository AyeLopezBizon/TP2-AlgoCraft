package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.creador.CreadorHerramienta;
import fiuba.algo3.tp2.herramienta.creador.MaterialesMalPosicionadosException;
import fiuba.algo3.tp2.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Vacio;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreadorDeHerramientaTest {

	@Test
	public void cuandoAgreganLosMaterialesAlaMesaDeTrabajoParaConstruirUnHachaDeMadera_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMadera()
			throws Exception{
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

		mesaDeTrabajo.setMaterial(new Madera(),1);
		mesaDeTrabajo.setMaterial(new Madera(),2);
		mesaDeTrabajo.setMaterial(new Vacio(), 3);
		mesaDeTrabajo.setMaterial(new Madera(),4);
		mesaDeTrabajo.setMaterial(new Madera(),5);
		mesaDeTrabajo.setMaterial(new Vacio(), 6);
		mesaDeTrabajo.setMaterial(new Vacio(), 7);
		mesaDeTrabajo.setMaterial(new Madera(),8);
		mesaDeTrabajo.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals( new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(2));
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnHachaDePiedra_ElCreadorDeHerramientasDeberiaCrearUnHachaDePiedra()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

		mesaDeTrabajo.setMaterial(new Piedra(),1);
		mesaDeTrabajo.setMaterial(new Piedra(),2);
		mesaDeTrabajo.setMaterial(new Vacio(), 3);
		mesaDeTrabajo.setMaterial(new Piedra(),4);
		mesaDeTrabajo.setMaterial(new Madera(),5);
		mesaDeTrabajo.setMaterial(new Vacio(), 6);
		mesaDeTrabajo.setMaterial(new Vacio(), 7);
		mesaDeTrabajo.setMaterial(new Madera(),8);
		mesaDeTrabajo.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(5), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnHachaDeMetal_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMetal()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();


		mesaDeTrabajo.setMaterial(new Metal(),1);
		mesaDeTrabajo.setMaterial(new Metal(),2);
		mesaDeTrabajo.setMaterial(new Vacio(), 3);
		mesaDeTrabajo.setMaterial(new Metal(),4);
		mesaDeTrabajo.setMaterial(new Madera(),5);
		mesaDeTrabajo.setMaterial(new Vacio(), 6);
		mesaDeTrabajo.setMaterial(new Vacio(), 7);
		mesaDeTrabajo.setMaterial(new Madera(),8);
		mesaDeTrabajo.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(400));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(10));
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnPicoDeMadera_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDeMadera()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

		mesaDeTrabajo.setMaterial(new Madera(),1);
		mesaDeTrabajo.setMaterial(new Madera(),2);
		mesaDeTrabajo.setMaterial(new Madera(), 3);
		mesaDeTrabajo.setMaterial(new Vacio(),4);
		mesaDeTrabajo.setMaterial(new Madera(),5);
		mesaDeTrabajo.setMaterial(new Vacio(), 6);
		mesaDeTrabajo.setMaterial(new Vacio(), 7);
		mesaDeTrabajo.setMaterial(new Madera(),8);
		mesaDeTrabajo.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();


		Assert.assertEquals(new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(2), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoDePiedra_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDePiedra()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

		mesaDeTrabajo.setMaterial(new Piedra(),1);
		mesaDeTrabajo.setMaterial(new Piedra(),2);
		mesaDeTrabajo.setMaterial(new Piedra(), 3);
		mesaDeTrabajo.setMaterial(new Vacio(),4);
		mesaDeTrabajo.setMaterial(new Madera(),5);
		mesaDeTrabajo.setMaterial(new Vacio(), 6);
		mesaDeTrabajo.setMaterial(new Vacio(), 7);
		mesaDeTrabajo.setMaterial(new Madera(),8);
		mesaDeTrabajo.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(4), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoDeMetal_ElCreadorDeHerramientasDeberiaCrearUnPicoDeMetal()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

		mesaDeTrabajo.setMaterial(new Metal(),1);
		mesaDeTrabajo.setMaterial(new Metal(),2);
		mesaDeTrabajo.setMaterial(new Metal(), 3);
		mesaDeTrabajo.setMaterial(new Vacio(),4);
		mesaDeTrabajo.setMaterial(new Madera(),5);
		mesaDeTrabajo.setMaterial(new Vacio(), 6);
		mesaDeTrabajo.setMaterial(new Vacio(), 7);
		mesaDeTrabajo.setMaterial(new Madera(),8);
		mesaDeTrabajo.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(400), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(12), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoFino_ElCreadorDeHerramientasDeberiaCrearUnPicoFino()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

		mesaDeTrabajo.setMaterial(new Metal(),1);
		mesaDeTrabajo.setMaterial(new Metal(),2);
		mesaDeTrabajo.setMaterial(new Metal(), 3);
		mesaDeTrabajo.setMaterial(new Piedra(),4);
		mesaDeTrabajo.setMaterial(new Madera(),5);
		mesaDeTrabajo.setMaterial(new Vacio(), 6);
		mesaDeTrabajo.setMaterial(new Vacio(), 7);
		mesaDeTrabajo.setMaterial(new Madera(),8);
		mesaDeTrabajo.setMaterial(new Vacio(), 9);

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		Herramienta herramienta = creador.crearHerramienta();

		Assert.assertEquals(new BigDecimal(1000), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(20), herramienta.getFuerza());
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoEnUnaDisposicionIncorrecta_ElCreadorDeHerramientasDeberiaLanzarUnaExcepcion()
			throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

		for (int i = 1; i < 10; i++) {
			mesaDeTrabajo.setMaterial(new Metal(), i);
		}

		CreadorHerramienta creador = new CreadorHerramienta(mesaDeTrabajo);
		creador.crearHerramienta();
	}
}
