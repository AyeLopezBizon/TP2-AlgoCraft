package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;

public class TableroPicoMadera extends Tablero {
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newPicoDeMadera();
	}
}