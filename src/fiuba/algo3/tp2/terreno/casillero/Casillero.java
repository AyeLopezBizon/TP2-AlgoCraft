package fiuba.algo3.tp2.terreno.casillero;

import fiuba.algo3.tp2.terreno.Posicion;
import fiuba.algo3.tp2.terreno.Posicionable;

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

	public void ocuparCasillero(Posicionable jugador) 
			throws CasilleroOcupadoException {
		
		espacio = espacio.ocupar(jugador);
	}
}
