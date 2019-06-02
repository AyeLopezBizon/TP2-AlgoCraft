package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;
import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Golpeable;

public class GolpeRompeMadera implements Golpe {

	private Integer fuerza;

	public GolpeRompeMadera(Integer fuerza) {
		
		this.fuerza = fuerza;
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
