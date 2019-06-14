package fiuba.algo3.tp2.matriz.casillero;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public class FilaCasillero {

	private Integer numeroFila;
	private Integer cantidadDeCasilleros;
	private Collection<Casillero> casilleros;
	

	public FilaCasillero(Integer numeroFila, Integer cantidadDeCasilleros) {
		
		this.numeroFila = numeroFila;
		this.cantidadDeCasilleros = cantidadDeCasilleros;
		inicializarCasilleros();
	}

	private void inicializarCasilleros() {
		
		casilleros = new ArrayList<Casillero>();
		for(int numeroColumna = 1; numeroColumna <= cantidadDeCasilleros; numeroColumna++) {
			casilleros.add(new Casillero(new Posicion(numeroColumna, numeroFila)));
		}
	}

	public void ocuparCasillero(Posicionable jugador, Posicion posicion) 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		
		Casillero casillero = buscarCasillero(posicion);
		casillero.ocuparCasillero(jugador);
	}

	public Casillero obtenerCasillero(Posicion posicion) throws CasilleroNoEncontradoException {
		
		Casillero casillero = buscarCasillero(posicion);
		return casillero;
	}
	
	private Casillero buscarCasillero(Posicion posicion) throws CasilleroNoEncontradoException {
		
		Casillero casilleroADevolver = null;
		for(Casillero casillero : casilleros) {
			if(casillero.tienePosicion(posicion)) {
				casilleroADevolver = casillero;
			}
		}
		
		if(casilleroADevolver == null) {
			throw new CasilleroNoEncontradoException();
		}
		
		return casilleroADevolver;
	}

	public Boolean contieneCasillero(Posicion posicion) {
		
		Boolean contieneCasillero = posicion.perteneceAFila(numeroFila);
		try {
			buscarCasillero(posicion);
		} catch(CasilleroNoEncontradoException exception){
			contieneCasillero = false;
		}
		return contieneCasillero;
	}

	public void desocuparCasillero(Posicion posicion) throws CasilleroNoEncontradoException {
		Casillero casillero = buscarCasillero(posicion);
		casillero.desocuparCasillero();
	}
}