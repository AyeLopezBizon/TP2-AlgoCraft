package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Metal;

public class MesaDeTrabajoHachaMetal extends MesaDeTrabajoVacia {

	public MesaDeTrabajoHachaMetal() {
		super();
		material[0]=new Metal();
		material[1]=new Metal();
		material[3]=new Metal();
		material[4]=new Madera();
		material[7]=new Madera();
	}
	
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMetal();
	}
}
