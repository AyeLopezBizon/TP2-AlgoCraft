package fiuba.algo3.tp2.herramienta;

import fiuba.algo3.tp2.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.material.*;

public class PicoFino extends Herramienta {
	
	public PicoFino(Durabilidad durabilidad, Golpe golpe) {
		super(durabilidad, golpe);
	}

	public void reducirDurabilidad(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(madera);
	}

	public void reducirDurabilidad(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(piedra);
	}

	public void reducirDurabilidad(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(metal);
	}
}
