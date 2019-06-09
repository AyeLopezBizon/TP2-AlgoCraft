package fiuba.algo3.tp2.terreno;

public class Posicion {

	private Integer numeroColumna;
	private Integer numeroFila;

	public Posicion(Integer numeroColumna, Integer numeroFila) {
		
		this.numeroColumna = numeroColumna;
		this.numeroFila = numeroFila;
	}

	public Boolean esIgualA(Posicion otraPosicion) {
		return numeroColumna.equals(otraPosicion.numeroColumna) 
				&& numeroFila.equals(otraPosicion.numeroFila);
	}

	public Boolean perteneceAFila(Integer numeroDeFila) {
		return numeroFila.equals(numeroDeFila);
	}

	public void avanzarColumna() {
		this.numeroColumna += 1;
	}

	public void retrocederColumna() {
		this.numeroColumna -= 1;
	}

	public void avanzarFila() {
		this.numeroFila += 1;
	}

	public void retrocederFila() {
		this.numeroFila -= 1;
	}
}