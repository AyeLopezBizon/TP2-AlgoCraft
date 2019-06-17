package fiuba.algo3.tp2.matriz.casillero;

public abstract class EspacioCasillero<T> {

	public abstract T obtenerValor() throws CasilleroVacioException;
	
	public abstract EspacioCasillero<T> ocupar(T valor) throws CasilleroOcupadoException;

	public abstract EspacioCasillero<T> desocupar() throws CasilleroVacioException;
}
