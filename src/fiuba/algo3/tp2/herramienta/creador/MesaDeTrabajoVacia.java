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
		/*
		for(int i = 1; i < 4; i++){
			for(int j = 1; j < 4; j++){
				materiales.ocuparCasillero(new Vacio(), new Posicion(new Integer(i), new Integer(j)));
			}
		}*/
	}

	@Override
	public Herramienta crearHerramienta() {
		return null;	//Nunca se llama a este metodo
	}
}
