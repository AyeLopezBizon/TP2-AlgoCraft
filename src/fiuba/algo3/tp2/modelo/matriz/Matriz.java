package fiuba.algo3.tp2.modelo.matriz;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.casillero.FilaCasillero;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class Matriz<T> {

	private Integer cantidadDeColumnas;
	private Integer cantidadDeFilas;
	private Collection<FilaCasillero<T>> filasCasilleros;
	
	public Matriz(Integer cantidadDeColumnas, Integer cantidadDeFilas) {
		
		this.cantidadDeColumnas = cantidadDeColumnas;
		this.cantidadDeFilas = cantidadDeFilas;
		inicializarFilasCasilleros();
	}

	public void ocuparCasillero(T valor, Posicion posicion) 
			throws CasilleroNoEncontradoException, CasilleroOcupadoException {
		
		FilaCasillero<T> filaCasillero = buscarFilaCasillero(posicion);
		filaCasillero.ocuparCasillero(valor, posicion);
	}
	
	public T obtenerValor(Posicion posicion) 
			throws CasilleroNoEncontradoException, CasilleroVacioException {
		
		return buscarCasillero(posicion).obtenerValor();
	}
	
	public void desocuparCasillero(Posicion posicion)
			throws CasilleroNoEncontradoException, CasilleroVacioException {

		FilaCasillero<T> filaCasillero = buscarFilaCasillero(posicion);
		filaCasillero.desocuparCasillero(posicion);
	}
	
	public Casillero<T> obtenerCasillero(Posicion posicion) throws CasilleroNoEncontradoException {
		return buscarCasillero(posicion);
	}
	
	private void inicializarFilasCasilleros() {
		
		filasCasilleros = new ArrayList<FilaCasillero<T>>();
		for(int numeroFila = 1; numeroFila <= cantidadDeFilas; numeroFila++) {
			
			filasCasilleros.add(new FilaCasillero<T>(numeroFila, cantidadDeColumnas));
		}
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
}
