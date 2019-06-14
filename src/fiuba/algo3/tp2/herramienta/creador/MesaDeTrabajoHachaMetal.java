package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;

public class MesaDeTrabajoHachaMetal extends MesaDeTrabajo {

	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMetal();
	}
}
