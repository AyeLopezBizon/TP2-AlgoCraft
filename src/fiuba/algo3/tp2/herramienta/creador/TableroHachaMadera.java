package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Madera;

public class TableroHachaMadera extends Tablero{

	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMadera();
	}
}
