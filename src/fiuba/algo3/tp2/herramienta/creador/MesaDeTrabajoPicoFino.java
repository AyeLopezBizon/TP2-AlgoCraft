package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.*;

public class MesaDeTrabajoPicoFino extends MesaDeTrabajoVacia {

	public MesaDeTrabajoPicoFino() {
		super();
		material[0]=new Metal();
		material[1]=new Metal();
		material[2]=new Metal();
		material[3]=new Piedra();
		material[4]=new Madera();
		material[7]=new Madera();
	}
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newPicoFino();
	}
}
