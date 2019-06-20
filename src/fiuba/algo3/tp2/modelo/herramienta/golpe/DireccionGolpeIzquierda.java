package fiuba.algo3.tp2.modelo.herramienta.golpe;

import fiuba.algo3.tp2.modelo.jugador.DireccionGolpe;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.Terreno;

public class DireccionGolpeIzquierda extends DireccionGolpe {

	public DireccionGolpeIzquierda(Jugador jugador, Terreno terreno) {
		super(jugador, terreno);
	}

	@Override
	public void lanzarGolpe(Posicion posicion) throws CasilleroNoEncontradoException, CasilleroVacioException {
		terreno.obtenerOcupanteTerreno(posicion.retrocederColumna()).recibirGolpe(jugador);
	}
}
