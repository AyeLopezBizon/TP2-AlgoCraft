package fiuba.algo3.tp2.modelo.matriz.casillero;

public class EspacioCasilleroOcupado<T> extends EspacioCasillero<T> {
	
	private T valor;

	public EspacioCasilleroOcupado(T valor) {
		
		this.valor = valor;
	}

	@Override
	public T obtenerValor() {
		return valor;
	}

	@Override
	public EspacioCasillero<T> ocupar(T valor) throws CasilleroOcupadoException {
		throw new CasilleroOcupadoException();
	}

	@Override
	public EspacioCasillero<T> desocupar() throws CasilleroVacioException {
		return new EspacioCasilleroLibre<T>();
	}
}
