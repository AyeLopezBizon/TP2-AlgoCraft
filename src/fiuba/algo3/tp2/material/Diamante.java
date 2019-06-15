package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

import java.math.BigDecimal;

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
	public boolean esIgualA(Material material) {
		return material.esIgualA(this);
	}

	@Override
	public boolean esIgualA(Madera madera) {
		return false;
	}

	@Override
	public boolean esIgualA(Piedra piedra) {
		return false;
	}

	@Override
	public boolean esIgualA(Metal metal) {
		return false;
	}

	@Override
	public boolean esIgualA(Diamante diamante) {
		return true;
	}

	@Override
	public boolean esIgualA(Vacio vacio) {
		return false;
	}
}
