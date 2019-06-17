package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.terreno.Terreno;

public abstract class DireccionGolpe {

	protected Terreno terreno;
	protected Jugador jugador;

	public DireccionGolpe(Jugador jugador, Terreno terreno) {
		this.terreno = terreno;
		this.jugador = jugador;
	}
	
	public abstract void lanzarGolpe(Posicion posicion) throws CasilleroNoEncontradoException, CasilleroVacioException;
}
