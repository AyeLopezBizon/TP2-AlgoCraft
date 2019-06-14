package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.Madera;
import fiuba.algo3.tp2.material.Piedra;

public class MesaDeTrabajoHachaPiedra extends MesaDeTrabajoVacia {

	public MesaDeTrabajoHachaPiedra() {
		super();
		material[0]=new Piedra();
		material[1]=new Piedra();
		material[3]=new Piedra();
		material[4]=new Madera();
		material[7]=new Madera();
	}
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDePiedra();
	}

}
