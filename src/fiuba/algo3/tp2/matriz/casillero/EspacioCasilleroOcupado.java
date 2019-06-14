package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class EspacioCasilleroOcupado<T extends Posicionable> extends EspacioCasillero<T> {
	
	private T posicionable;

	public EspacioCasilleroOcupado(T posicionable) {
		
		this.posicionable = posicionable;
	}

	@Override
	public T obtenerPosicionable() {
		return posicionable;
	}

	@Override
	public EspacioCasillero<T> ocupar(T posicionable) throws CasilleroOcupadoException {
		throw new CasilleroOcupadoException();
	}

	@Override
	public EspacioCasillero<T> desocupar() throws CasilleroVacioException {
		return new EspacioCasilleroLibre<T>();
	}
}
