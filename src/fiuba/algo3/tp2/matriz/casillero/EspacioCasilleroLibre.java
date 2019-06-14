package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.material.Vacio;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class EspacioCasilleroLibre extends EspacioCasillero {

	private Posicionable posicionable;
	
	
	public EspacioCasilleroLibre() {
		this.posicionable = new Vacio();
	}
	
	@Override
	public Posicionable obtenerPosicionable() {
		return posicionable;
	}

	@Override
	public EspacioCasillero ocupar(Posicionable posicionable) throws CasilleroOcupadoException {
		
		return new EspacioCasilleroOcupado(posicionable);
	}
}
