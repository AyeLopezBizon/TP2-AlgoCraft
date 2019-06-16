package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public abstract class EspacioCasillero<T extends Posicionable> {

	public abstract T obtenerPosicionable() throws CasilleroVacioException;
	
	public abstract EspacioCasillero<T> ocupar(T posicionable) throws CasilleroOcupadoException;

	public abstract EspacioCasillero<T> desocupar() throws CasilleroVacioException;

	public abstract boolean esIgualA(EspacioCasillero<T> espacioCasillero);

	public abstract boolean esIgualA(EspacioCasilleroLibre<T> espacioCasillero);

	public abstract boolean esIgualA(EspacioCasilleroOcupado<T> espacioCasillero);
}
