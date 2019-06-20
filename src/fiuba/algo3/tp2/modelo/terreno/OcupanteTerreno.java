package fiuba.algo3.tp2.modelo.terreno;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicionable;

public interface OcupanteTerreno extends Posicionable {

	void recibirGolpe(Jugador jugador);

	void setTerreno(Terreno terreno);
}
