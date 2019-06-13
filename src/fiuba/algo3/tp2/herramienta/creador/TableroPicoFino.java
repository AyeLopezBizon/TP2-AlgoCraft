package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;

public class TableroPicoFino extends Tablero {

	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newPicoFino();
	}
}
