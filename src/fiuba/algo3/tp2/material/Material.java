package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.herramienta.golpe.Golpeable;

import java.math.BigDecimal;

public abstract class Material implements Golpeable {

	protected BigDecimal durabilidad;
	
	public Material(BigDecimal durabilidad) {
		this.durabilidad = durabilidad;
	}
	
	public BigDecimal getDurabilidad() {
		return durabilidad;
	}
	
	public void reducirDurabilidad(BigDecimal danio)
			throws MaterialDestruidoNoSePuedeGolpearException {
		
		if(durabilidad.equals(new BigDecimal(0))) {
			throw new MaterialDestruidoNoSePuedeGolpearException();
		}
		
		durabilidad = durabilidad.subtract(danio);
		
		// La durabilidad no puede ser negativa, 
		// si el danio es mayor a la durabilidad se setea en 0
		if(durabilidad.compareTo(new BigDecimal(0)) < 0){
			durabilidad = new BigDecimal(0);
		}
	}

	public abstract void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void serGolpeadoPor(Herramienta herramienta)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException;
}