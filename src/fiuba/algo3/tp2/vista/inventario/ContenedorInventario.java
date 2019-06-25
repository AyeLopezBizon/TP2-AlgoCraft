package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.CreadorHerramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ContenedorInventario extends VBox {
	
	public ContenedorInventario(Jugador jugador, MesaDeTrabajo mesaDeTrabajo, 
			CreadorHerramienta creadorHerramienta) throws NoSePuedeInicializarContenedorMesaDeTrabajo {
		
		setearFondoYDistribucionComponentes();
		
		crearContenedorSuperior(jugador, mesaDeTrabajo, creadorHerramienta);
		crearContenedorInferior(jugador);
	}
	
	private void setearFondoYDistribucionComponentes() {
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
		this.setPrefHeight(100);
		this.setMaxHeight(100);
		this.setPrefWidth(200);
		this.setMaxWidth(200);
		this.setBackground(new Background(new BackgroundFill(Color.GREY, 
				CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, new BorderWidths(4))));
	}

	private void crearContenedorSuperior(Jugador jugador, MesaDeTrabajo mesaDeTrabajo, 
			CreadorHerramienta creadorHerramienta) 
					throws NoSePuedeInicializarContenedorMesaDeTrabajo {
		
		ContenedorHerramientaActiva contenedorHerramientaActiva;
		contenedorHerramientaActiva = new ContenedorHerramientaActiva(jugador);
		
		ContenedorCreadorHerramienta contenedorCreador;
		contenedorCreador = new ContenedorCreadorHerramienta(jugador.obtenerInventario(), mesaDeTrabajo, creadorHerramienta);

		ContenedorSuperiorInventario contenedorSuperiorInventario = 
				new ContenedorSuperiorInventario(contenedorHerramientaActiva, contenedorCreador);
		
		getChildren().add(contenedorSuperiorInventario);
		
		VistaHerramientaActiva vistaHerramientaActiva = new VistaHerramientaActiva(contenedorHerramientaActiva);
		jugador.addObserver(vistaHerramientaActiva);
	}

	private void crearContenedorInferior(Jugador jugador) {
		
		ContenedorAlmacenables contenedorAlmacenables = new ContenedorAlmacenables(jugador);
		getChildren().add(contenedorAlmacenables);
	}
}
