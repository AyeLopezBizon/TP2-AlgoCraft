package fiuba.algo3.tp2.terreno;

import fiuba.algo3.tp2.matriz.Matriz;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class Terreno {
	
	private Matriz<OcupanteTerreno> matrizTerreno;
	
	
	public Terreno(Integer cantidadDeColumnas, Integer cantidadDeFilas) {
		
		matrizTerreno = new Matriz<OcupanteTerreno>(cantidadDeColumnas, cantidadDeFilas);
	}

	public void ocuparCasillero(OcupanteTerreno posicionable, Posicion posicion) 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		
		matrizTerreno.ocuparCasillero(posicionable, posicion);
	}

	public OcupanteTerreno obtenerOcupanteTerreno(Posicion posicion) 
			throws CasilleroNoEncontradoException, CasilleroVacioException {
		
		return matrizTerreno.obtenerPosicionable(posicion);
	}

	public void desocuparCasillero(Posicion posicion)
			throws CasilleroNoEncontradoException, CasilleroVacioException {

		matrizTerreno.desocuparCasillero(posicion);
	}
}