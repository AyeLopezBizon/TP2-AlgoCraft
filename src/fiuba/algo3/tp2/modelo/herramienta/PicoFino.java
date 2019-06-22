package fiuba.algo3.tp2.modelo.herramienta;

import fiuba.algo3.tp2.modelo.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.modelo.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

public class PicoFino extends Herramienta {
	
	public PicoFino(Durabilidad durabilidad, Golpe golpe, String nombre) {
		super(durabilidad, golpe, nombre);
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
