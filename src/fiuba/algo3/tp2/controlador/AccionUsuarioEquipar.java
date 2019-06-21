package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;

public class AccionUsuarioEquipar implements AccionUsuario {

	private Jugador jugador;

	public AccionUsuarioEquipar(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void ejecutar() {
		try {
			jugador.equipar(1);
		} catch (EspacioVacioException e) {
		}
	}
}
