package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class EspacioCasilleroOcupado extends EspacioCasillero {
	
	private Posicionable posicionable;

	public EspacioCasilleroOcupado(Posicionable posicionable) {
		
		this.posicionable = posicionable;
	}

	@Override
	public Posicionable obtenerPosicionable() {
		return posicionable;
	}

	@Override
	public EspacioCasillero ocupar(Posicionable posicionable) throws CasilleroOcupadoException {
		throw new CasilleroOcupadoException();
	}
}
