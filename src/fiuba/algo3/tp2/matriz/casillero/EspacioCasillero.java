package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public abstract class EspacioCasillero {

	public abstract Posicionable obtenerPosicionable();
	
	public abstract EspacioCasillero ocupar(Posicionable posicionable) throws CasilleroOcupadoException;

}
