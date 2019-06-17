package fiuba.algo3.tp2.terreno;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public interface OcupanteTerreno extends Posicionable {

	void recibirGolpe(Jugador jugador);

	void setTerreno(Terreno terreno);
}
