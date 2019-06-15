package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.material.Vacio;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class MesaDeTrabajoVacia extends MesaDeTrabajo{
	
	public MesaDeTrabajoVacia() 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		super();
	}

	@Override
	public Herramienta crearHerramienta() throws MesaDeTrabajoIncorrectaException {
		throw new MesaDeTrabajoIncorrectaException();
	}
}
