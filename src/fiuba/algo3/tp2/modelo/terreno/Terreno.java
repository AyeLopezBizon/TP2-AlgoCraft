package fiuba.algo3.tp2.modelo.terreno;

import fiuba.algo3.tp2.modelo.matriz.Matriz;
import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class Terreno {
	
	private Integer cantidadDeFilas;
	private Integer cantidadDeColumnas;
	private Matriz<OcupanteTerreno> matrizTerreno;
	
	
	public Terreno(Integer cantidadDeColumnas, Integer cantidadDeFilas) {
		
		this.cantidadDeFilas = cantidadDeFilas;
		this.cantidadDeColumnas = cantidadDeColumnas;
		matrizTerreno = new Matriz<OcupanteTerreno>(cantidadDeColumnas, cantidadDeFilas);
	}

	public void ocuparCasillero(OcupanteTerreno posicionable, Posicion posicion) 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		
		matrizTerreno.ocuparCasillero(posicionable, posicion);
		posicionable.posicionar(posicion);
		posicionable.setTerreno(this);
	}

	public OcupanteTerreno obtenerOcupanteTerreno(Posicion posicion) 
			throws CasilleroNoEncontradoException, CasilleroVacioException {
		
		return matrizTerreno.obtenerValor(posicion);
	}

	public void desocuparCasillero(Posicion posicion)
			throws CasilleroNoEncontradoException, CasilleroVacioException {

		matrizTerreno.desocuparCasillero(posicion);
	}

	public Integer obtenerCantidadFilas() {
		return cantidadDeFilas;
	}
	
	public Integer obtenerCantidadColumnas() {
		return cantidadDeColumnas;
	}

	public Casillero<OcupanteTerreno> obtenerCasillero(Posicion posicion) throws CasilleroNoEncontradoException {
		return matrizTerreno.obtenerCasillero(posicion);
	}
}