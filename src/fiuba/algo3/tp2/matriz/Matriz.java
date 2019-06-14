package fiuba.algo3.tp2.matriz;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.matriz.casillero.Casillero;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.FilaCasillero;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class Matriz {

	private Integer cantidadDeColumnas;
	private Integer cantidadDeFilas;
	private Collection<FilaCasillero> filasCasilleros;
	
	public Matriz(Integer cantidadDeColumnas, Integer cantidadDeFilas) {
		
		this.cantidadDeColumnas = cantidadDeColumnas;
		this.cantidadDeFilas = cantidadDeFilas;
		inicializarFilasCasilleros();
	}

	private void inicializarFilasCasilleros() {
		
		filasCasilleros = new ArrayList<FilaCasillero>();
		for(int numeroFila = 1; numeroFila <= cantidadDeFilas; numeroFila++) {
			
			filasCasilleros.add(new FilaCasillero(numeroFila, cantidadDeColumnas));
		}
	}

	public void ocuparCasillero(Posicionable posicionable, Posicion posicion) 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		
		FilaCasillero filaCasillero = buscarFilaCasillero(posicion);
		filaCasillero.ocuparCasillero(posicionable, posicion);
	}
	
	public Posicionable obtenerPosicionable(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		return buscarCasillero(posicion).obtenerPosicionable();
	}
	
	public void desocuparCasillero(Posicion posicion)
			throws CasilleroNoEncontradoException {

		FilaCasillero filaCasillero = buscarFilaCasillero(posicion);
		filaCasillero.desocuparCasillero(posicion);
	}
	
	private Casillero buscarCasillero(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		FilaCasillero fila = buscarFilaCasillero(posicion);
		return fila.obtenerCasillero(posicion);
	}

	private FilaCasillero buscarFilaCasillero(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		FilaCasillero filaCasilleroADevolver = null;
		for(FilaCasillero filaCasillero : filasCasilleros) {
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
