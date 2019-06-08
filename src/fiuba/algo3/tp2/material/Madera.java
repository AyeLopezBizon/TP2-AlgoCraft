package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;

import java.math.BigDecimal;

public class Madera extends Material {
	
	private static final BigDecimal durabilidadInicial = new BigDecimal(10);
	
	public Madera() {
		super(durabilidadInicial);
	}

	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(this);
	}

	public void serGolpeadoPor(Herramienta herramienta) throws MaterialDestruidoNoSePuedeGolpearException {

		herramienta.reducirDurabilidad(this);
	}
}
