package fiuba.algo3.tp2.modelo.terreno;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.matriz.Matriz;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class Terreno extends Observable {
	
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
		
		this.setChanged();
		notifyObservers(new Object[] { "ocuparCasillero", posicionable, posicion });
	}

	public OcupanteTerreno obtenerOcupanteTerreno(Posicion posicion) 
			throws CasilleroNoEncontradoException, CasilleroVacioException {
		
		return matrizTerreno.obtenerValor(posicion);
	}

	public void desocuparCasillero(Posicion posicion)
			throws CasilleroNoEncontradoException, CasilleroVacioException {

		matrizTerreno.desocuparCasillero(posicion);
		
		this.setChanged();
		notifyObservers(new Object[] { "desocuparCasillero", posicion });
	}

	public Integer obtenerCantidadFilas() {
		return cantidadDeFilas;
	}
	
	public Integer obtenerCantidadColumnas() {
		return cantidadDeColumnas;
	}
}