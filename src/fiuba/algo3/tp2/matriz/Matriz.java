package fiuba.algo3.tp2.matriz;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.matriz.casillero.Casillero;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.casillero.FilaCasillero;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class Matriz<T extends Posicionable> {

	private Integer cantidadDeColumnas;
	private Integer cantidadDeFilas;
	private Collection<FilaCasillero<T>> filasCasilleros;
	
	public Matriz(Integer cantidadDeColumnas, Integer cantidadDeFilas) {
		
		this.cantidadDeColumnas = cantidadDeColumnas;
		this.cantidadDeFilas = cantidadDeFilas;
		inicializarFilasCasilleros();
	}

	private void inicializarFilasCasilleros() {
		
		filasCasilleros = new ArrayList<FilaCasillero<T>>();
		for(int numeroFila = 1; numeroFila <= cantidadDeFilas; numeroFila++) {
			
			filasCasilleros.add(new FilaCasillero<T>(numeroFila, cantidadDeColumnas));
		}
	}

	public void ocuparCasillero(T posicionable, Posicion posicion) 
			throws CasilleroNoEncontradoException, CasilleroOcupadoException {
		
		FilaCasillero<T> filaCasillero = buscarFilaCasillero(posicion);
		filaCasillero.ocuparCasillero(posicionable, posicion);
	}
	
	public T obtenerPosicionable(Posicion posicion) 
			throws CasilleroNoEncontradoException, CasilleroVacioException {
		
		return buscarCasillero(posicion).obtenerPosicionable();
	}
	
	public void desocuparCasillero(Posicion posicion)
			throws CasilleroNoEncontradoException, CasilleroVacioException {

		FilaCasillero<T> filaCasillero = buscarFilaCasillero(posicion);
		filaCasillero.desocuparCasillero(posicion);
	}
	
	private Casillero<T> buscarCasillero(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		FilaCasillero<T> fila = buscarFilaCasillero(posicion);
		return fila.obtenerCasillero(posicion);
	}

	private FilaCasillero<T> buscarFilaCasillero(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		FilaCasillero<T> filaCasilleroADevolver = null;
		for(FilaCasillero<T> filaCasillero : filasCasilleros) {
			if(filaCasillero.contieneCasillero(posicion)) {
				filaCasilleroADevolver = filaCasillero;
			}
		}
		
		if(filaCasilleroADevolver == null) {
			throw new CasilleroNoEncontradoException();
		}
		return filaCasilleroADevolver;
	}

	public boolean comparar(Matriz<T> otraMatriz) throws CasilleroNoEncontradoException {

		for(int i = 1; i <= this.cantidadDeFilas; i++){
			for(int j = 1; j <= this.cantidadDeColumnas; j++) {
				Posicion posicion = new Posicion(i, j);
				if(!this.buscarCasillero(posicion).esIgualA(otraMatriz.buscarCasillero(posicion))){
					return false;
				}
			}
		}

		return true;
	}
}
