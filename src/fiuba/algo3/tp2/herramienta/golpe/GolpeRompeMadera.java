package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Golpeable;

import java.math.BigDecimal;

public class GolpeRompeMadera extends Golpe {

	public GolpeRompeMadera(BigDecimal fuerza) {
		super(fuerza);
	}

	public void golpear(Golpeable material) throws MaterialDestruidoNoSePuedeGolpearException {
		material.golpearCon(this);
	}

	public void golpear(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException {
		madera.reducirDurabilidad(fuerza);
	}
	
	public void golpear(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException {
		// No reduce la durabilidad de la piedra
	}
	
	public void golpear(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException {
		// No reduce la durabilidad del metal
	}
	
	public void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException {
		// No reduce la durabilidad del diamante
	}
}
