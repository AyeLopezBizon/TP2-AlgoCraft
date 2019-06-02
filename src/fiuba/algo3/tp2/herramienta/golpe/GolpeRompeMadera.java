package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Golpeable;

import java.math.BigDecimal;

public class GolpeRompeMadera implements Golpe {

	private BigDecimal fuerza;

	public GolpeRompeMadera(BigDecimal fuerza) {
		
		this.fuerza = fuerza;
	}

	public BigDecimal getFuerza() {
		return fuerza;
	}

	@Override
	public void golpear(Golpeable golpeable) throws MaterialDestruidoNoSePuedeGolpearException {
		
		golpeable.golpearCon(this);
	}

	@Override
	public void golpear(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException {
		
		madera.reducirDurabilidad(fuerza);
	}
	
	@Override
	public void golpear(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException {
		// No se reduce la durabilidad de la piedra
	}
	
	@Override
	public void golpear(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException {
		// No se reduce la durabilidad del metal
	}
	
	@Override
	public void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException {
		// No se reduce la durabilidad del diamante
	}
}
