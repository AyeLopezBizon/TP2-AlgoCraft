package fiuba.algo3.tp2.modelo.herramienta.creador;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;

public class MesaDeTrabajoVacia extends MesaDeTrabajo{
	
	public MesaDeTrabajoVacia() 
			throws NoSePuedeInicializarMesaDeTrabajoException {
		super();
	}

	@Override
	public Herramienta crearHerramienta() throws MesaDeTrabajoIncorrectaException {
		throw new MesaDeTrabajoIncorrectaException();
	}
}
