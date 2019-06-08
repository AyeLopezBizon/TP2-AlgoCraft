package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Golpeable;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

import java.math.BigDecimal;

public class GolpeRompeMetal extends Golpe {

	public GolpeRompeMetal(BigDecimal fuerza) {
		super(fuerza);
	}

	public void golpear(Golpeable material) throws MaterialDestruidoNoSePuedeGolpearException {
		material.golpearCon(this);
	}

	public void golpear(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException {
		// No reduce la durabilidad de la madera
	}

	public void golpear(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException {
		piedra.reducirDurabilidad(fuerza);
	}

	public void golpear(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException {
		metal.reducirDurabilidad(fuerza);
	}

	public void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException {
		// No reduce la durabilidad del diamante
	}
}
