package fiuba.algo3.tp2.terreno;

import fiuba.algo3.tp2.matriz.posicion.Posicionable;
import fiuba.algo3.tp2.jugador.Jugador;

public interface OcupanteTerreno extends Posicionable {

	public void recibirGolpe(Jugador jugador);
}
