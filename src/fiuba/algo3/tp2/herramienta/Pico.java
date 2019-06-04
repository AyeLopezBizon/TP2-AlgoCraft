package fiuba.algo3.tp2.herramienta;

import fiuba.algo3.tp2.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.material.*;

public class Pico extends Herramienta {
	
	public Pico(Durabilidad durabilidad, Golpe golpe) {
		super(durabilidad, golpe);
	}

	public void reducirDurabilidad(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException {

		durabilidad.reducir();
		golpe.golpear(madera);
	}

	public void reducirDurabilidad(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException {

		durabilidad.reducir();
		golpe.golpear(piedra);
	}

	public void reducirDurabilidad(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException {

		durabilidad.reducir();
		golpe.golpear(metal);
	}

	public void reducirDurabilidad(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException {

		durabilidad.reducir();
		golpe.golpear(diamante);
	}
}
