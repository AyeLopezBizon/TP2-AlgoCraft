package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import javafx.scene.layout.HBox;

public class ContenedorCreadorHerramienta extends HBox {
	public ContenedorCreadorHerramienta() throws NoSePuedeInicializarMesaDeTrabajoException {
		ContenedorMesaDeTrabajo contenedorMesa = new ContenedorMesaDeTrabajo();
		this.getChildren().add(contenedorMesa);
		/*
		ContenedorBotones contenedorBotones = new ContenedorBotones();
		this.getChildren().add(contenedorBotones);
		*/
		
	}
}
