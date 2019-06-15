package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.matriz.Matriz;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.matriz.posicion.Posicionable;

public abstract class MesaDeTrabajo{
	
	protected Matriz<Material> materiales;

	public MesaDeTrabajo() throws CasilleroOcupadoException, CasilleroNoEncontradoException{

		materiales = new Matriz(new Integer(3), new Integer(3));
	}
	
	public void setMaterial(Material material, Posicion posicion)
			throws PosicionIncorrectaException, CasilleroOcupadoException, CasilleroNoEncontradoException {
		if(posicion.obtenerNumFilas()<1 || posicion.obtenerNumFilas()>3 
		 	|| posicion.obtenerNumColumnas()<1 || posicion.obtenerNumColumnas()>3) {
			throw new PosicionIncorrectaException();
		}
		
		materiales.ocuparCasillero(material, posicion);
	}
	
	public Posicionable getCasilla(Posicion posicion) throws PosicionIncorrectaException {
		try{
			return materiales.obtenerPosicionable(posicion);
		}catch(CasilleroNoEncontradoException | CasilleroVacioException e) {
			throw new PosicionIncorrectaException();
		}
	}
	
	public boolean comparar(MesaDeTrabajo mesaDeTrabajo)
			throws PosicionIncorrectaException, CasilleroNoEncontradoException, CasilleroVacioException {

		return this.materiales.comparar(mesaDeTrabajo.materiales);
	}

	public abstract Herramienta crearHerramienta();
}
