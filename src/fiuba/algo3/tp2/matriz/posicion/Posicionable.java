package fiuba.algo3.tp2.matriz.posicion;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.terreno.OcupanteTerreno;

public interface Posicionable {

	public void posicionar(Posicion posicion);
	public Posicion obtenerPosicion();

	boolean esIgualA(Posicionable posicionable);

	boolean esIgualA(OcupanteTerreno ocupanteTerreno);

	boolean esIgualA(Jugador jugador);
}
