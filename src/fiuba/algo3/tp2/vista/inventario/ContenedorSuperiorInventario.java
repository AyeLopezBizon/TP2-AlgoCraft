package fiuba.algo3.tp2.vista.inventario;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ContenedorSuperiorInventario extends HBox {

	public ContenedorSuperiorInventario(ContenedorHerramientaActiva contenedorHerramientaActiva,
			ContenedorCreadorHerramienta contenedorCreador) {
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(100);
		this.getChildren().add(contenedorHerramientaActiva);
		this.getChildren().add(contenedorCreador);
	}
}
