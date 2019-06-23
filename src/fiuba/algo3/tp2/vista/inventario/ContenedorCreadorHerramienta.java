package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import javafx.scene.layout.HBox;

public class ContenedorCreadorHerramienta extends HBox {
	
	public ContenedorCreadorHerramienta(Inventario inventario, MesaDeTrabajo mesaDeTrabajo) throws NoSePuedeInicializarMesaDeTrabajoException {
		ContenedorMesaDeTrabajo contenedorMesa = new ContenedorMesaDeTrabajo(inventario, mesaDeTrabajo);
		this.getChildren().add(contenedorMesa);
		/*
		ContenedorBotones contenedorBotones = new ContenedorBotones();
		this.getChildren().add(contenedorBotones);
		*/
	}
}
