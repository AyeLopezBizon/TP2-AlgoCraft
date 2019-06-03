package fiuba.algo3.tp2.herramienta;

import java.math.BigDecimal;
import java.math.RoundingMode;

import fiuba.algo3.tp2.herramienta.durabilidad.DurabilidadLineal;
import fiuba.algo3.tp2.herramienta.durabilidad.DurabilidadPorcentual;
import fiuba.algo3.tp2.herramienta.durabilidad.DurabilidadRupturaAbrupta;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeDiamante;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeMadera;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompeMetal;
import fiuba.algo3.tp2.herramienta.golpe.GolpeRompePiedra;

/*
 * Clase que se encarga de instanciar los distintos tipos de herramientas
 * inyectando las dependencias correctas para cada una de ellas.
 * 
 * Cuando se quiera instanciar una herramienta debe usarse esta clase.
 */
public class HerramientaFactory {

	public static Herramienta newHachaDeMadera() {
		return new Hacha(new DurabilidadLineal(new BigDecimal(100), new BigDecimal(2)), new GolpeRompeMadera(new BigDecimal(2)));
	}

	public static Herramienta newHachaDePiedra() {
		return new Hacha(new DurabilidadLineal(new BigDecimal(200), new BigDecimal(5)), new GolpeRompeMadera(new BigDecimal(5)));
	}

	public static Herramienta newHachaDeMetal() {
		return new Hacha(new DurabilidadLineal(new BigDecimal(400), new BigDecimal(5)), new GolpeRompeMadera(new BigDecimal(10)));
	}

	public static Herramienta newPicoDeMadera() {
		return new Pico(new DurabilidadLineal(new BigDecimal(100), new BigDecimal(2)), new GolpeRompePiedra(new BigDecimal(2)));
	}

	public static Herramienta newPicoDePiedra() {
		return new Pico(new DurabilidadLineal(new BigDecimal(200),
				new BigDecimal(4).divide(new BigDecimal(1.5), 2, RoundingMode.HALF_UP)), new GolpeRompeMetal(new BigDecimal(4)));
	}

	public static Herramienta newPicoDeMetal() {
		return new Pico(new DurabilidadRupturaAbrupta(new BigDecimal(400), new BigDecimal(10)), new GolpeRompeMetal(new BigDecimal(12)));
	}

	public static Herramienta newPicoFino() {
		return new PicoFino(new DurabilidadPorcentual(new BigDecimal(1000), new BigDecimal(10)), new GolpeRompeDiamante(new BigDecimal(20)));
	}
}