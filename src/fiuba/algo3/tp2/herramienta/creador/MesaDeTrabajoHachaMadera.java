package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Madera;

public class MesaDeTrabajoHachaMadera extends MesaDeTrabajo{

	public MesaDeTrabajoHachaMadera() {
		super();
		material[0]=new Madera();
		material[1]=new Madera();
		material[3]=new Madera();
		material[4]=new Madera();
		material[7]=new Madera();
	}
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMadera();
	}
}
