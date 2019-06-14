package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.material.Vacio;

public class MesaDeTrabajoVacia extends MesaDeTrabajo {
	
	public MesaDeTrabajoVacia(){
		super();
		for(int i = 0; i < 9; i++) {
			this.material[i]= new Vacio();
		}
	}
	
	
	@Override
	public Herramienta crearHerramienta(){
		return null;
	}
}
