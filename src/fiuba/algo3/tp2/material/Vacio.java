package fiuba.algo3.tp2.material;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

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
		return false;
	}

	@Override
	public boolean esIgualA(Vacio vacio) {
		return true;
	}

}
