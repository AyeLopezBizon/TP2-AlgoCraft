package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

import java.math.BigDecimal;

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
