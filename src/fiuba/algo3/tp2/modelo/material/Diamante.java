package fiuba.algo3.tp2.modelo.material;

import java.math.BigDecimal;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.modelo.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadDiamante;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;

public class Diamante extends Material {

	public Diamante() {
		super(new BigDecimal(100));
	}

	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(this);
	}

	public void serGolpeadoPor(Herramienta herramienta)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		herramienta.reducirDurabilidad(this);
	}

	@Override
	protected UnidadMaterial obtenerUnidadMaterial() {
		return new UnidadDiamante();
	}
}
