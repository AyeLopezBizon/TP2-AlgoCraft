package fiuba.algo3.tp2.vista.inventario;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class ContenedorSuperiorInventario extends BorderPane {

	public ContenedorSuperiorInventario(ContenedorHerramientaActiva contenedorHerramientaActiva,
			ContenedorCreadorHerramienta contenedorCreador) {
		/*
		this.setAlignment(Pos.CENTER);
		this.setSpacing(100);
		
		this.getChildren().add(contenedorHerramientaActiva);
		this.getChildren().add(contenedorCreador);
		*/
		BorderPane.setAlignment(contenedorHerramientaActiva, Pos.CENTER);
		BorderPane.setMargin(contenedorHerramientaActiva, new Insets(0, 0, 0, 50));
		setLeft(contenedorHerramientaActiva);
		setRight(contenedorCreador);
	}
}
