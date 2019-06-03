package fiuba.algo3.tp2.herramienta;

import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;

import java.math.BigDecimal;

public abstract class Herramienta {
	
	protected Durabilidad durabilidad;
	protected Golpe golpe;
	
	public Herramienta(Durabilidad durabilidad, Golpe golpe) {
		this.durabilidad = durabilidad;
		this.golpe = golpe;
	}

	public BigDecimal getDurabilidad() {
		return durabilidad.getValor();
	}
	
	public void golpear(Material material) 
			throws MaterialDestruidoNoSePuedeGolpearException {
		
	//	durabilidad.reducir();
	//	golpe.golpear(material);

		material.reducir(this);
	}

	public BigDecimal getFuerza() {
		return golpe.getFuerza();
	}

	public abstract void reducirDurabilidad(Madera madera) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void reducirDurabilidad(Piedra piedra) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void reducirDurabilidad(Metal metal) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void reducirDurabilidad(Diamante diamante) throws MaterialDestruidoNoSePuedeGolpearException;
}
