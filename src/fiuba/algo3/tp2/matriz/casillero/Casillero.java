package fiuba.algo3.tp2.matriz.casillero;

import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class Casillero {

	private Posicion posicion;
	private EspacioCasillero espacio;
	
	
	public Casillero(Posicion posicion) {
		this.espacio = new EspacioCasilleroLibre();
		this.posicion = posicion;
	}

	public Posicionable obtenerPosicionable() {
		return espacio.obtenerPosicionable();
	}

	public Boolean tienePosicion(Posicion posicion) {
		return posicion.esIgualA(this.posicion);
	}

	public void ocuparCasillero(Posicionable posicionable) 
			throws CasilleroOcupadoException {
		
		espacio = espacio.ocupar(posicionable);
		posicionable.posicionar(posicion);
	}

	public void desocuparCasillero() {
		this.espacio = new EspacioCasilleroLibre();
	}
}