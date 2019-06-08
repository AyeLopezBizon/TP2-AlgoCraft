package fiuba.algo3.tp2.herramienta.golpe;

import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;

public interface Golpeable {

	void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException;
}
