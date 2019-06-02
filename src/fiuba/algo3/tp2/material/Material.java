package fiuba.algo3.tp2.material;

import java.math.BigDecimal;

public abstract class Material implements Golpeable {

	protected Integer durabilidad;
	
	public Material(Integer durabilidad) {
		this.durabilidad = durabilidad;
	}
	
	public Integer getDurabilidad() {
		return durabilidad;
	}
	
	public void reducirDurabilidad(BigDecimal danio) throws MaterialDestruidoNoSePuedeGolpearException {
		
		if(durabilidad == 0) {
			throw new MaterialDestruidoNoSePuedeGolpearException();
		}
		
		durabilidad = durabilidad.subtra danio;
		
		// La durabilidad no puede ser negativa, 
		// si el danio es mayor a la durabilidad se setea en 0
		if(durabilidad < 0) {
			durabilidad = 0;
		}
	}
}
