package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class EspacioCasilleroLibre<T extends Posicionable> extends EspacioCasillero<T> {
	
	@Override
	public T obtenerPosicionable() 
			throws CasilleroVacioException {
		throw new CasilleroVacioException();
	}

	@Override
	public EspacioCasillero<T> ocupar(T posicionable) throws CasilleroOcupadoException {
		
		return new EspacioCasilleroOcupado<T>(posicionable);
	}

	@Override
	public EspacioCasillero<T> desocupar() throws CasilleroVacioException {
		throw new CasilleroVacioException();
	}
}
