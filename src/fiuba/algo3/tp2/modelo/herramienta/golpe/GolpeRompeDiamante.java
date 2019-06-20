package fiuba.algo3.tp2.modelo.herramienta.golpe;

import java.math.BigDecimal;

import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;

public class GolpeRompeDiamante extends Golpe {

	public GolpeRompeDiamante(BigDecimal fuerza) {
		super(fuerza);
	}

	public void golpear(Golpeable material) throws MaterialDestruidoNoSePuedeGolpearException {
		material.golpearCon(this);
	}

	public void golpear(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException {
		madera.reducirDurabilidad(fuerza);
	}

	public void golpear(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException {
		piedra.reducirDurabilidad(fuerza);
	}

	public void golpear(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException {
		metal.reducirDurabilidad(fuerza);
	}

	public void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException {
		diamante.reducirDurabilidad(fuerza);
	}
}
