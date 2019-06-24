package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.CreadorHerramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ContenedorCreadorHerramienta extends HBox {
	
	public ContenedorCreadorHerramienta(Inventario inventario, MesaDeTrabajo mesaDeTrabajo, CreadorHerramienta creadorHerramienta) throws NoSePuedeInicializarMesaDeTrabajoException {
		
		setAlignment(Pos.CENTER_RIGHT);
		
		ContenedorMesaDeTrabajo contenedorMesa = new ContenedorMesaDeTrabajo(inventario, mesaDeTrabajo);
		this.getChildren().add(contenedorMesa);
		
		ContenedorBotones contenedorBotones = new ContenedorBotones(inventario, mesaDeTrabajo, creadorHerramienta);
		this.getChildren().add(contenedorBotones);
		
	}
}
