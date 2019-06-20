package fiuba.algo3.tp2.modelo.herramienta.golpe;

import java.math.BigDecimal;

import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

public abstract class  Golpe {

	protected BigDecimal fuerza;

	public Golpe(BigDecimal fuerza) {
		this.fuerza = fuerza;
	}

	public BigDecimal getFuerza() {
		return fuerza;
	}

	public abstract void golpear(Golpeable material) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void golpear(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void golpear(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void golpear(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException;
}
