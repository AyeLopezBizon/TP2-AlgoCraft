package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;

public class MesaDeTrabajoVacia extends MesaDeTrabajo{
	
	public MesaDeTrabajoVacia() 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		super();		
	}

	@Override
	public Herramienta crearHerramienta() {
		return null;	//Nunca se llama a este metodo
	}
}
