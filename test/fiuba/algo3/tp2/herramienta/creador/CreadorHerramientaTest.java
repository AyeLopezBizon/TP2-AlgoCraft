package fiuba.algo3.tp2.herramienta.creador;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;


public class CreadorHerramientaTest {
	@Test
	public void cuandoSeConstruyeUnTablero_DeberiaTenerTodasLasCasillasVacias() {
		Tablero tablero = new Tablero();
		
		for(int i=0; i<9; i++) {
			Assert.assertEquals(tablero.getCasilla(i).getDurabilidad(), new BigDecimal(0));	
		}	
	}
	
	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnHachaDeMadera_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMadera() {
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
		
		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(100));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(2));
	}
	
	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnHachaDePiedra_ElCreadorDeHerramientasDeberiaCrearUnHachaDePiedra() {
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
		
		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(200));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(5));
	}
	
	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnHachaDeMetal_ElCreadorDeHerramientasDeberiaCrearUnHachaDeMetal() {
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
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnPicoDeMadera_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDeMadera() {
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
		
		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(100));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(2));
	}
	
	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnUnPicoDePiedra_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDePiedra() {
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
		
		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(200));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(4));
	}
	
	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnUnPicoDeMetal_ElCreadorDeHerramientasDeberiaCrearUnUnPicoDeMetal() {
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
		
		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(400));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(12));
	}
	
	@Test
	public void cuandoAgreganLosMaterialesAlTableroParaConstruirUnUnPicoFino_ElCreadorDeHerramientasDeberiaCrearUnPicoFino() {
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
		
		Assert.assertEquals(herramienta.getDurabilidad(), new BigDecimal(100));
		Assert.assertEquals(herramienta.getFuerza(), new BigDecimal(20));
	}
	

}
