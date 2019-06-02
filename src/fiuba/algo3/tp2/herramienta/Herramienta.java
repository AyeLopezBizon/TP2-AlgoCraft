package fiuba.algo3.tp2.herramienta;

import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;

public abstract class Herramienta {
	
	protected Durabilidad durabilidad;
	protected Golpe golpe;
	
	public Herramienta(Durabilidad durabilidad, Golpe golpe) {
		this.durabilidad = durabilidad;
		this.golpe = golpe;
	}

	public float getDurabilidad() {
		return durabilidad.getValor();
	}
	
	public Integer getFuerza() {
		return golpe.getFuerza();
	}
	
	public void golpear(Material material) 
			throws MaterialDestruidoNoSePuedeGolpearException {
		
		durabilidad.reducir();
		golpe.golpear(material);
	}
}
