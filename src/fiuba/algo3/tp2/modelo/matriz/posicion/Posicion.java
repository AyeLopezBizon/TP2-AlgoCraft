package fiuba.algo3.tp2.modelo.matriz.posicion;

import fiuba.algo3.tp2.modelo.matriz.casillero.FilaCasillero;

public class Posicion {

	private Integer numeroColumna;
	private Integer numeroFila;

	public Posicion(Integer numeroColumna, Integer numeroFila) {
		
		this.numeroColumna = numeroColumna;
		this.numeroFila = numeroFila;
	}
	
	public Integer obtenerNumeroColumna() {
		return numeroColumna;
	}
	
	public Integer obtenerNumeroFila() {
		return numeroFila;
	}
	
	public Boolean esIgualA(Posicion otraPosicion) {
		return numeroColumna.equals(otraPosicion.numeroColumna) 
				&& numeroFila.equals(otraPosicion.numeroFila);
	}

	public Boolean perteneceAFila(FilaCasillero<?> filaCasillero) {
		return numeroFila.equals(filaCasillero.obtenerNumeroFila())
				&& numeroColumna.compareTo(filaCasillero.obtenerLargo()) <= 0;
	}

	public Posicion avanzarColumna() {
		return new Posicion(this.numeroColumna + 1, this.numeroFila);
	}

	public Posicion retrocederColumna() {
		return new Posicion(this.numeroColumna - 1, this.numeroFila);
	}

	public Posicion avanzarFila() {
		return new Posicion(this.numeroColumna, this.numeroFila + 1);
	}

	public Posicion retrocederFila() {
		return new Posicion(this.numeroColumna, this.numeroFila - 1);
	}
}