package fiuba.algo3.tp2.matriz.casillero;

public class EspacioCasilleroLibre<T> extends EspacioCasillero<T> {
	
	@Override
	public T obtenerValor() 
			throws CasilleroVacioException {
		
		throw new CasilleroVacioException();
	}

	@Override
	public EspacioCasillero<T> ocupar(T valor) throws CasilleroOcupadoException {
		
		return new EspacioCasilleroOcupado<T>(valor);
	}
	
	@Override
	public EspacioCasillero<T> desocupar() throws CasilleroVacioException {
		throw new CasilleroVacioException();
	}
}
