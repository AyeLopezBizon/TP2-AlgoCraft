package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.golpe.Golpe;

public class Madera extends Material {
	
	private static final Integer durabilidadInicial = 10;
	
	public Madera() {
		super(durabilidadInicial);
	}

	@Override
	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(this);
	}
}
