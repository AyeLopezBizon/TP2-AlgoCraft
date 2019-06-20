package fiuba.algo3.tp2.modelo.jugador;

import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.Terreno;

public abstract class DireccionGolpe {

	protected Terreno terreno;
	protected Jugador jugador;

	public DireccionGolpe(Jugador jugador, Terreno terreno) {
		this.terreno = terreno;
		this.jugador = jugador;
	}
	
	public abstract void lanzarGolpe(Posicion posicion) throws CasilleroNoEncontradoException, CasilleroVacioException;
}
