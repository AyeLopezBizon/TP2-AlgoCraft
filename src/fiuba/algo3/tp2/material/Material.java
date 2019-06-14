package fiuba.algo3.tp2.material;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.herramienta.golpe.Golpeable;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public abstract class Material implements Golpeable, Posicionable {
	
	protected BigDecimal durabilidad;
	private Posicion posicion;
	
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

	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
	
	public abstract void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException;

	public abstract void serGolpeadoPor(Herramienta herramienta)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException;
}