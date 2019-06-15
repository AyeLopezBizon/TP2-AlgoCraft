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
	private final Integer cantFilas = 3;
	private final Integer cantColumnas = 3;

	public MesaDeTrabajo() throws CasilleroOcupadoException, CasilleroNoEncontradoException{

		materiales = new Matriz(cantFilas, cantColumnas);
	}
	
	public void agregarMaterial(Material material, Posicion posicion)
			throws PosicionIncorrectaException {

		try{
			materiales.ocuparCasillero(material, posicion);
		}catch(CasilleroNoEncontradoException | CasilleroOcupadoException e){
			throw new PosicionIncorrectaException();
		}
	}
	
	public Posicionable obtenerPosicionable(Posicion posicion) throws PosicionIncorrectaException {
		try{
			return materiales.obtenerPosicionable(posicion);
		}catch(CasilleroNoEncontradoException | CasilleroVacioException e) {
			throw new PosicionIncorrectaException();
		}
	}
	
	public boolean comparar(MesaDeTrabajo mesaDeTrabajo)
			throws CasilleroNoEncontradoException {

		return this.materiales.comparar(mesaDeTrabajo.materiales);
	}

	public abstract Herramienta crearHerramienta() throws MesaDeTrabajoIncorrectaException;

	public void limpiarMesaDeTrabajo() throws CasilleroVacioException, CasilleroNoEncontradoException {

		for(int i = 1; i <= cantFilas; i++) {
			for(int j = 1; j <= cantColumnas; j++) {
				Posicion posicion = new Posicion(i, j);
				materiales.desocuparCasillero(posicion);
			}
		}
	}
}
