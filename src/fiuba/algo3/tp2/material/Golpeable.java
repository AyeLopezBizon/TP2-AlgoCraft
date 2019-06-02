package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;

public interface Golpeable {

	void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException;
}
