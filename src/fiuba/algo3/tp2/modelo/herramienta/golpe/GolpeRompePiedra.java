package fiuba.algo3.tp2.modelo.herramienta.golpe;

import java.math.BigDecimal;

import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

public class GolpeRompePiedra extends Golpe {

	public GolpeRompePiedra(BigDecimal fuerza) {
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
		// No reduce la durabilidad del metal
	}

	public void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException {
		// No reduce la durabilidad del diamante
	}
}
