package fiuba.algo3.tp2.material;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.terreno.Terreno;
import fiuba.algo3.tp2.unidadMaterial.UnidadDiamante;
import fiuba.algo3.tp2.unidadMaterial.UnidadMaterial;

public class Diamante extends Material {

	public Diamante(Terreno terreno) {
		super(terreno, new BigDecimal(100));
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
