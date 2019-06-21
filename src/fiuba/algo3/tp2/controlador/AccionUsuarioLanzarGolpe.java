package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.direccion.Direccion;

public class AccionUsuarioLanzarGolpe implements AccionUsuario {

	private Jugador jugador;
	private Direccion direccion;

	public AccionUsuarioLanzarGolpe(Jugador jugador, Direccion direccion) {
		this.jugador = jugador;
		this.direccion = direccion;
	}

	@Override
	public void ejecutar() {
		try {
			jugador.lanzarGolpe(direccion);
		} catch (CasilleroNoEncontradoException | CasilleroVacioException e) {
		}
	}
}
