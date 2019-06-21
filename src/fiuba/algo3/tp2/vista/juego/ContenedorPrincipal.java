package fiuba.algo3.tp2.vista.juego;

import fiuba.algo3.tp2.vista.inventario.ContenedorInventario;
import fiuba.algo3.tp2.vista.terreno.ContenedorTerreno;
import javafx.scene.layout.StackPane;

public class ContenedorPrincipal extends StackPane {

	public ContenedorPrincipal(ContenedorTerreno contenedorTerreno, ContenedorInventario contenedorInventario) {
		
		getChildren().add(contenedorTerreno);
		getChildren().add(contenedorInventario);
		contenedorInventario.setVisible(false);
	}
}
