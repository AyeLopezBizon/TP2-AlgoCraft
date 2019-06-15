package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Vacio;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class MesaDeTrabajoHachaMadera extends MesaDeTrabajo{

	public MesaDeTrabajoHachaMadera() 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		super();
		
		matriz.ocuparCasillero(new Madera(),new Posicion(new Integer(1), new Integer(1)));
		matriz.ocuparCasillero(new Madera(),new Posicion(new Integer(1), new Integer(2)));
		matriz.ocuparCasillero(new Vacio(),new Posicion(new Integer(1), new Integer(3)));
		matriz.ocuparCasillero(new Madera(),new Posicion(new Integer(2), new Integer(1)));
		matriz.ocuparCasillero(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		matriz.ocuparCasillero(new Vacio(),new Posicion(new Integer(2), new Integer(3)));
		matriz.ocuparCasillero(new Vacio(),new Posicion(new Integer(3), new Integer(1)));
		matriz.ocuparCasillero(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		matriz.ocuparCasillero(new Vacio(),new Posicion(new Integer(3), new Integer(3)));
	}
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMadera();
	}
}
