package fiuba.algo3.tp2.material;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;

public class Vacio extends Material {

	public Vacio() {
		super(new BigDecimal(0));
	}

	@Override
	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		
	}

	@Override
	public void serGolpeadoPor(Herramienta herramienta)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {
		
	}

}
