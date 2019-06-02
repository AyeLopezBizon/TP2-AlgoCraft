package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;

import java.math.BigDecimal;

public class Piedra extends Material {

	public Piedra() {
		super(new BigDecimal(30));
	}

	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(this);
	}
}
