package fiuba.algo3.tp2.modelo.herramienta.creador;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.material.UnidadMaterialVacio;
import fiuba.algo3.tp2.modelo.matriz.Matriz;
import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;

public abstract class MesaDeTrabajo{
	
	protected Matriz<UnidadMaterial> materiales;
	private final Integer cantidadDeFilas = 3;
	private final Integer cantidadDeColumnas = 3;

	
	public MesaDeTrabajo() 
			throws NoSePuedeInicializarMesaDeTrabajoException {

		materiales = new Matriz<UnidadMaterial>(cantidadDeFilas, cantidadDeColumnas);
		inicializar();
	}
	
	public abstract Herramienta crearHerramienta() throws MesaDeTrabajoIncorrectaException;
	
	private void inicializar() throws NoSePuedeInicializarMesaDeTrabajoException {
		
		try {
			for(int i = 1; i <= this.cantidadDeFilas; i++){
				for(int j = 1; j <= this.cantidadDeColumnas; j++) {
					Posicion posicion = new Posicion(i, j);
					materiales.ocuparCasillero(new UnidadMaterialVacio(), posicion);
				}
			}
		} catch (CasilleroNoEncontradoException | CasilleroOcupadoException e) {
			throw new NoSePuedeInicializarMesaDeTrabajoException();
		}
	}

	public void agregarMaterial(UnidadMaterial material, Posicion posicion)
			throws PosicionIncorrectaException {

		try{
			if(!materiales.obtenerValor(posicion).esVacio()) {
				throw new PosicionIncorrectaException();
			}
			materiales.desocuparCasillero(posicion);
			materiales.ocuparCasillero(material, posicion);
		}catch(CasilleroNoEncontradoException | CasilleroOcupadoException | CasilleroVacioException e){
			throw new PosicionIncorrectaException();
		}
	}
	
	public void quitarMaterial(Posicion posicion)
			throws PosicionIncorrectaException {

		try{
			if(materiales.obtenerValor(posicion).esVacio()) {
				throw new PosicionIncorrectaException();
			}
			materiales.desocuparCasillero(posicion);
			materiales.ocuparCasillero(new UnidadMaterialVacio(), posicion);
		}catch(CasilleroNoEncontradoException | CasilleroOcupadoException | CasilleroVacioException e){
			throw new PosicionIncorrectaException();
		}
	}
	
	public UnidadMaterial obtenerPosicionable(Posicion posicion) 
			throws PosicionIncorrectaException {
		try{
			return materiales.obtenerValor(posicion);
		}catch(CasilleroNoEncontradoException | CasilleroVacioException e) {
			throw new PosicionIncorrectaException();
		}
	}
	
	public boolean comparar(MesaDeTrabajo mesaDeTrabajo) {

		try {
			for(int i = 1; i <= this.cantidadDeFilas; i++){
				for(int j = 1; j <= this.cantidadDeColumnas; j++) {
					Posicion posicion = new Posicion(i, j);
					
						if(!obtenerPosicionable(posicion).esIgualA(mesaDeTrabajo.obtenerPosicionable(posicion))){
							return false;
						}
	
				}
			}
		} catch (PosicionIncorrectaException e) {
			// No deberia ocurrir
		}
		return true;
	}

	public void limpiarMesaDeTrabajo() throws CasilleroVacioException, CasilleroNoEncontradoException, CasilleroOcupadoException {

		for(int i = 1; i <= cantidadDeFilas; i++) {
			for(int j = 1; j <= cantidadDeColumnas; j++) {
				Posicion posicion = new Posicion(i, j);
				materiales.desocuparCasillero(posicion);
				materiales.ocuparCasillero(new UnidadMaterialVacio(), posicion);
			}
		}
	}

	public int getCantidadDeFilas() {
		return this.cantidadDeFilas;
	}

	public int getCantidadDeColumnas() {
		return this.cantidadDeColumnas;
	}

	public Casillero<UnidadMaterial> obtenerCasillero(Posicion posicion) throws CasilleroNoEncontradoException {
		return materiales.obtenerCasillero(posicion);
	}
}
