package fiuba.algo3.tp2.herramienta;

import fiuba.algo3.tp2.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.material.*;

public class PicoFino extends Herramienta {
	
	public PicoFino(Durabilidad durabilidad, Golpe golpe) {
		super(durabilidad, golpe);
	}

	@Override
	public void golpear(Material material)
			throws MaterialDestruidoNoSePuedeGolpearException {

		//durabilidad.reducir();
		//Falta el caso de diamante en el que si se reduce la durabilidad.
		golpe.golpear(material);
	}
}
