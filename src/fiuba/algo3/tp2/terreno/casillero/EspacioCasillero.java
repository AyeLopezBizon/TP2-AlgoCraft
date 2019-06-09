package fiuba.algo3.tp2.terreno.casillero;

import fiuba.algo3.tp2.terreno.Posicionable;

public abstract class EspacioCasillero {

	public abstract Posicionable obtenerPosicionable();
	
	public abstract EspacioCasillero ocupar(Posicionable posicionable) throws CasilleroOcupadoException;

}
