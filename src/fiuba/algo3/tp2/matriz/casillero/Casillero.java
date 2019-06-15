package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class Casillero<T extends Posicionable> {

	private Posicion posicion;
	private EspacioCasillero<T> espacio;
	
	
	public Casillero(Posicion posicion) {
		this.espacio = new EspacioCasilleroLibre<T>();
		this.posicion = posicion;
	}

	public T obtenerPosicionable() throws CasilleroVacioException {
		return espacio.obtenerPosicionable();
	}

	public Boolean tienePosicion(Posicion posicion) {
		return posicion.esIgualA(this.posicion);
	}

	public void ocuparCasillero(T posicionable) 
			throws CasilleroOcupadoException {
		
		espacio = espacio.ocupar(posicionable);
		posicionable.posicionar(posicion);
	}

	public void desocuparCasillero() throws CasilleroVacioException {
		this.espacio = espacio.desocupar();
	}
}