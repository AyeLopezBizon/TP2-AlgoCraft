package fiuba.algo3.tp2.terreno;

import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;
import fiuba.algo3.tp2.jugador.Jugador;

public interface OcupanteTerreno extends Posicionable {

	void recibirGolpe(Jugador jugador);

	boolean esIgualA(OcupanteTerreno ocupanteTerreno);

	boolean esIgualA(Jugador jugador);

	boolean esIgualA(Material material);
}
