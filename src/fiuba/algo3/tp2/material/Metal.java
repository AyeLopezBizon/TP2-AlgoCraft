package fiuba.algo3.tp2.material;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;

public class Metal extends Material {

	public Metal() {
		super(new BigDecimal(50));
	}

	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(this);
	}

	public void serGolpeadoPor(Herramienta herramienta)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		herramienta.reducirDurabilidad(this);
	}
}
