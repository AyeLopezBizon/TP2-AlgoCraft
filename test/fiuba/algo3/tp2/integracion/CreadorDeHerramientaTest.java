package fiuba.algo3.tp2.integracion;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.CreadorHerramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.MaterialesMalPosicionadosException;
import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajoVacia;
import fiuba.algo3.tp2.modelo.material.UnidadMaterialVacio;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMadera;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMetal;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadPiedra;

public class CreadorDeHerramientaTest {

	@Test
	public void cuandoAgreganLosMaterialesAlaMesaDeTrabajoParaConstruirUnHachaDeMadera_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMadera()
			throws Exception{
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		Herramienta herramienta = creador.crearHerramienta(mesaDeTrabajo);

		Assert.assertEquals( new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(2));
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnHachaDePiedra_ElCreadorDeHerramientasDeberiaCrearUnHachaDePiedra()
			throws Exception
	{
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		Herramienta herramienta = creador.crearHerramienta(mesaDeTrabajo);

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(5), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnHachaDeMetal_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMetal()
			throws Exception {
		
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();


		mesaDeTrabajo.agregarMaterial(new UnidadMetal(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMetal(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMetal(), new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		Herramienta herramienta = creador.crearHerramienta(mesaDeTrabajo);

		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(400));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(10));
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnPicoDeMadera_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDeMadera()
			throws Exception {
		
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		Herramienta herramienta = creador.crearHerramienta(mesaDeTrabajo);


		Assert.assertEquals(new BigDecimal(100), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(2), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoDePiedra_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDePiedra()
			throws Exception {
		
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadPiedra(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		Herramienta herramienta = creador.crearHerramienta(mesaDeTrabajo);

		Assert.assertEquals(new BigDecimal(200), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(4), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoDeMetal_ElCreadorDeHerramientasDeberiaCrearUnPicoDeMetal()
			throws Exception {
		
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new UnidadMetal(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMetal(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMetal(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		Herramienta herramienta = creador.crearHerramienta(mesaDeTrabajo);

		Assert.assertEquals(new BigDecimal(400), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(12), herramienta.getFuerza());
	}

	@Test
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoParaConstruirUnUnPicoFino_ElCreadorDeHerramientasDeberiaCrearUnPicoFino()
			throws Exception {
		
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		mesaDeTrabajo.agregarMaterial(new UnidadMetal(),new Posicion(new Integer(1), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMetal(),new Posicion(new Integer(1), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMetal(), new Posicion(new Integer(1), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadPiedra(),new Posicion(new Integer(2), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(2), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(2), new Integer(3)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(1)));
		mesaDeTrabajo.agregarMaterial(new UnidadMadera(),new Posicion(new Integer(3), new Integer(2)));
		mesaDeTrabajo.agregarMaterial(new UnidadMaterialVacio(), new Posicion(new Integer(3), new Integer(3)));

		CreadorHerramienta creador = new CreadorHerramienta();
		Herramienta herramienta = creador.crearHerramienta(mesaDeTrabajo);

		Assert.assertEquals(new BigDecimal(1000), herramienta.getDurabilidad());
		Assert.assertEquals(new BigDecimal(20), herramienta.getFuerza());
	}

	@Test(expected = MaterialesMalPosicionadosException.class)
	public void cuandoAgreganLosMaterialesALaMesaDeTrabajoEnUnaDisposicionIncorrecta_ElCreadorDeHerramientasDeberiaLanzarUnaExcepcion()
			throws Exception {
		
		MesaDeTrabajoVacia mesaDeTrabajo = new MesaDeTrabajoVacia();

		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				mesaDeTrabajo.agregarMaterial(new UnidadMetal(), new Posicion(i,j));
			}
		}

		CreadorHerramienta creador = new CreadorHerramienta();
		creador.crearHerramienta(mesaDeTrabajo);
	}
}
