package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.matriz.Matriz;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public abstract class MesaDeTrabajo{
	
	protected Matriz matriz;

	public MesaDeTrabajo() throws CasilleroOcupadoException, CasilleroNoEncontradoException{
		matriz = new Matriz(new Integer(3), new Integer(3));
		/*for(int i=1; i<4; i++) {
			for(int j=1; j<4; j++) {
				matriz.ocuparCasillero(new Vacio(), new Posicion(i,j));
			}
		}	*/
	}
	
	public void setMaterial(Material material, Posicion posicion)
			throws PosicionIncorrectaException, CasilleroOcupadoException, CasilleroNoEncontradoException {
		if(posicion.obtenerNumFilas()<1 || posicion.obtenerNumFilas()>3 
		 	|| posicion.obtenerNumColumnas()<1 || posicion.obtenerNumColumnas()>3) {
			throw new PosicionIncorrectaException();
		}
		
		matriz.ocuparCasillero(material, posicion);
	}
	
	public Posicionable getCasilla(Posicion posicion) 
			throws PosicionIncorrectaException, CasilleroNoEncontradoException {
	if(posicion.obtenerNumFilas()<1 || posicion.obtenerNumFilas()>3 
	 	|| posicion.obtenerNumColumnas()<1 || posicion.obtenerNumColumnas()>3) {
		throw new PosicionIncorrectaException();
	}
		return matriz.obtenerPosicionable(posicion);		
	}
	
	public boolean comparar(MesaDeTrabajo mesaDeTrabajo) 
			throws PosicionIncorrectaException, CasilleroNoEncontradoException {
		boolean valor = true;
		
		for(int i=1;i<4;i++) {
			for(int j=1;j<4;j++) {
				if(!matriz.obtenerPosicionable(new Posicion(i, j)).getClass().equals(mesaDeTrabajo.getCasilla(new Posicion(i,j)).getClass())) {
					valor = false;
				}
			}
		}	
		return valor;
	}

	public abstract Herramienta crearHerramienta();
}
