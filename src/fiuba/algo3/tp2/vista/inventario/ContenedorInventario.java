package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ContenedorInventario extends VBox{

	Inventario inventario;
	
	public ContenedorInventario(Inventario inventario) throws NoSePuedeInicializarMesaDeTrabajoException {
		this.inventario=inventario;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
		
		ContenedorCreadorHerramienta contenedorCreador = new ContenedorCreadorHerramienta();
		this.getChildren().add(contenedorCreador);
		
		ContenedorAlmacenables contenedorAlmacenables = new ContenedorAlmacenables(inventario);
		this.getChildren().add(contenedorAlmacenables);

	}
	
	
}
