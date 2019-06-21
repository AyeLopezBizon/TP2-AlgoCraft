package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ContenedorInventario extends VBox{

	Inventario inventario;
	
	public ContenedorInventario(Jugador jugador) {
		
		try {
			this.inventario = jugador.obtenerInventario();
			
			this.setAlignment(Pos.CENTER);
			this.setSpacing(20);
			this.setPadding(new Insets(25));
			this.setPrefHeight(100);
			this.setMaxHeight(100);
			this.setPrefWidth(200);
			this.setMaxWidth(200);
			this.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
			
			ContenedorCreadorHerramienta contenedorCreador;
		
			contenedorCreador = new ContenedorCreadorHerramienta();

			this.getChildren().add(contenedorCreador);
			
			ContenedorAlmacenables contenedorAlmacenables = new ContenedorAlmacenables(inventario);
			this.getChildren().add(contenedorAlmacenables);
		} catch (NoSePuedeInicializarMesaDeTrabajoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
