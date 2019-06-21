package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.direccion.Direccion;
import fiuba.algo3.tp2.modelo.jugador.Jugador;

public class AccionUsuarioMoverJugador implements AccionUsuario {

	private Jugador jugador;
	private Direccion direccion;
	

	public AccionUsuarioMoverJugador(Jugador jugador, Direccion direccion) {
		this.jugador = jugador;
		this.direccion = direccion;
	}

	@Override
	public void ejecutar() {
		try {
			jugador.mover(direccion);
		} catch (CasilleroNoEncontradoException | CasilleroOcupadoException | CasilleroVacioException e) {
		}
	}
}
