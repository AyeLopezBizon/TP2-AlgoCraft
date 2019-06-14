package fiuba.algo3.tp2.terreno;

import fiuba.algo3.tp2.matriz.Matriz;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class Terreno {
	
	private Matriz matrizTerreno;
	
	
	public Terreno(Integer cantidadDeColumnas, Integer cantidadDeFilas) {
		
		matrizTerreno = new Matriz(cantidadDeColumnas, cantidadDeFilas);
	}

	public void ocuparCasillero(Posicionable posicionable, Posicion posicion) 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		
		matrizTerreno.ocuparCasillero(posicionable, posicion);
	}

	public Posicionable obtenerPosicionable(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		return matrizTerreno.obtenerPosicionable(posicion);
	}

	public void desocuparCasillero(Posicion posicion)
			throws CasilleroNoEncontradoException {

		matrizTerreno.desocuparCasillero(posicion);
	}
}