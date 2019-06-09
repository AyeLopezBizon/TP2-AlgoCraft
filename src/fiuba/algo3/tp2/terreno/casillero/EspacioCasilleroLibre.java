package fiuba.algo3.tp2.terreno.casillero;

import fiuba.algo3.tp2.terreno.Posicionable;
import fiuba.algo3.tp2.terreno.PosicionableVacio;

public class EspacioCasilleroLibre extends EspacioCasillero {

	private Posicionable posicionable;
	
	
	public EspacioCasilleroLibre() {
		this.posicionable = new PosicionableVacio();
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
