package fiuba.algo3.tp2.modelo.herramienta.golpe;

import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;

public interface Golpeable {

	void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException;
}
