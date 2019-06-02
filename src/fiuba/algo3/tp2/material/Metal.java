package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;

public class Metal extends Material {

	public Metal() {
		super(50);
	}

	@Override
	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(this);
	}
}
