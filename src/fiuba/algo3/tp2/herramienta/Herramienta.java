package fiuba.algo3.tp2.herramienta;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.herramienta.durabilidad.DurabilidadDesgastadaNoSePuedeReducirException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.material.Diamante;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.material.Metal;
import fiuba.algo3.tp2.material.Piedra;

public abstract class Herramienta implements Almacenable {
	
	protected Durabilidad durabilidad;
	protected Golpe golpe;
	
	public Herramienta(Durabilidad durabilidad, Golpe golpe) {
		this.durabilidad = durabilidad;
		this.golpe = golpe;
	}

	@Override
	public void equiparEn(Jugador jugador) {
		jugador.equipar(this);
	}

	public BigDecimal getDurabilidad() {
		return durabilidad.getValor();
	}

	public BigDecimal getFuerza() {
		return golpe.getFuerza();
	}

	public void golpear(Material material)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		material.serGolpeadoPor(this);
	}

	public void reducirDurabilidad(Madera madera)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			durabilidad.reducir();
		} catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}

		golpe.golpear(madera);
	}

	public void reducirDurabilidad(Piedra piedra)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			durabilidad.reducir();
		} catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}

		golpe.golpear(piedra);
	}

	public void reducirDurabilidad(Metal metal)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			durabilidad.reducir();
		} catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}

		golpe.golpear(metal);
	}

	public void reducirDurabilidad(Diamante diamante)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			durabilidad.reducir();
		}
		catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}

		golpe.golpear(diamante);
	}
}
