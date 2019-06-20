package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaCasilleroTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;

public class VistaJugador extends Vista implements VistaOcupanteTerreno {

	private VistaCasilleroTerreno vistaCasilleroTerreno;
	private Jugador jugador;

	public VistaJugador(VistaCasilleroTerreno vistaCasilleroTerreno, OcupanteTerreno ocupanteTerreno) {
		this.vistaCasilleroTerreno = vistaCasilleroTerreno;
		this.jugador = (Jugador)ocupanteTerreno;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dibujar() {
		String nombreImagen = jugador.getClass().getSimpleName() + ".png";
		vistaCasilleroTerreno.setBackground(obtenerImagen(nombreImagen));
	}
}