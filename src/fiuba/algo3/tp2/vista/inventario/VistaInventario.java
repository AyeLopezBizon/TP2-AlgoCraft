package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.vista.ocupanteTerreno.Vista;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaInventario extends Vista {
	
	Inventario inventario;
	
	public VistaInventario(Inventario inventario) {
		this.inventario=inventario;
	}

	public void mostrarInventario() throws NoSePuedeInicializarMesaDeTrabajoException {
		
		Stage stageCreador = new Stage();
		ContenedorInventario contenedorInventario = new ContenedorInventario(this.inventario);		
		Scene escenaCreadorHerramienta = new Scene(contenedorInventario);
		stageCreador.setTitle("Inventario");
		stageCreador.setScene(escenaCreadorHerramienta);
		stageCreador.show();
	
	}
}
