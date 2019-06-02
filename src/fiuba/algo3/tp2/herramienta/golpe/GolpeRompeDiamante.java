package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Golpeable;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

import java.math.BigDecimal;

public class GolpeRompeDiamante implements Golpe {
	
	private BigDecimal fuerza;
	
	public GolpeRompeDiamante(BigDecimal fuerza) {
		this.fuerza = fuerza;
	}

	public BigDecimal getFuerza() {
		return fuerza;
	}

	@Override
	public void golpear(Golpeable material) throws MaterialDestruidoNoSePuedeGolpearException {
		
		material.golpearCon(this);
	}

	@Override
	public void golpear(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException {
		
		madera.reducirDurabilidad(fuerza);
	}

	@Override
	public void golpear(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException {
		
		piedra.reducirDurabilidad(fuerza);
	}

	@Override
	public void golpear(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException {
		
		metal.reducirDurabilidad(fuerza);
	}

	@Override
	public void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException {
		
		diamante.reducirDurabilidad(fuerza);
	}
}
