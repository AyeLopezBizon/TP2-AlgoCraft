package fiuba.algo3.tp2.vista.terreno;

import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;

public class NoSePudoDibujarTerrenoException extends Exception {
	
	private static final long serialVersionUID = 7545902400842714805L;

	
	public NoSePudoDibujarTerrenoException(CasilleroNoEncontradoException e) {
		super(e);
	}
}
