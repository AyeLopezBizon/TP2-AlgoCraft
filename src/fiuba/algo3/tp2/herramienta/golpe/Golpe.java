package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Golpeable;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

import java.math.BigDecimal;

public interface Golpe {

	BigDecimal getFuerza();

	void golpear(Golpeable material) throws MaterialDestruidoNoSePuedeGolpearException;
	
	void golpear(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException;

	void golpear(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException;

	void golpear(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException;

	void golpear(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException;
}
