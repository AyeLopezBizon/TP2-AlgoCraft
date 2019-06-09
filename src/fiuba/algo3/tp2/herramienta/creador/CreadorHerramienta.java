package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.*;

public class CreadorHerramienta {
	
	CreadorHerramienta(Tablero tablero){
		
	}
	
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMadera();
	}
}
