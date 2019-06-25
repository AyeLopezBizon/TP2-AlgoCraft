package fiuba.algo3.tp2.vista.inicio;


import fiuba.algo3.tp2.controlador.inicio.BotonComenzarPartidaEventHandler;
import fiuba.algo3.tp2.controlador.inicio.BotonSalirEventHandler;
import fiuba.algo3.tp2.vista.Imagen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {
	
	private static final String CAPTION_BUTTON_COMENZAR_PARTIDA = "COMENZAR PARTIDA";
	private static final String CAPTION_BUTTON_SALIR = "SALIR";
	private Stage stage;

	public ContenedorInicio(Stage stage) {
		
		super();
		this.stage = stage;
		
		setearImagenFondoYDistribucionDeComponentes();

		agregarBotonComenzarPartida();
		agregarBotonSalir();
	}
	
	private void setearImagenFondoYDistribucionDeComponentes() {
    	
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		Image imagen = new Image(Imagen.FONDO_INICIO, 
								 primaryScreenBounds.getWidth(), 
								 primaryScreenBounds.getHeight(), 
								 false, 
								 true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));
	}

	private void agregarBotonComenzarPartida() {
		
		Button botonComenzarPartida = new Button();
		botonComenzarPartida.setText(CAPTION_BUTTON_COMENZAR_PARTIDA);
		botonComenzarPartida.setTextFill(Color.WHITE);
		botonComenzarPartida.setPrefHeight(50);
		botonComenzarPartida.setPrefWidth(250);
		botonComenzarPartida.setStyle(this.obtenerEstiloBoton());
		
		BotonComenzarPartidaEventHandler botonComenzarPartidaEventHandler = new BotonComenzarPartidaEventHandler(stage);
		botonComenzarPartida.setOnAction(botonComenzarPartidaEventHandler);
		
		this.getChildren().add(botonComenzarPartida);
	}
	
    private void agregarBotonSalir() {
    	
		Button botonSalir = new Button();
		botonSalir.setText(CAPTION_BUTTON_SALIR);
		botonSalir.setTextFill(Color.WHITE);
		botonSalir.setPrefHeight(50);
		botonSalir.setPrefWidth(250);
		botonSalir.setStyle(this.obtenerEstiloBoton());
		
		BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
		botonSalir.setOnAction(botonSalirEventHandler);
		
		this.getChildren().add(botonSalir);
	}

	private String obtenerEstiloBoton() {
    	
    	return "  -fx-border-size: 5px;" +
        		"  -fx-border-style: solid;" +
        		"  -fx-border-radius: 5px;" +
        		"  -fx-font-size: 15px;" + 
        		"  -fx-font-family: Arial, Helvetica, sans-serif;" +
        		"  -fx-font-weight: bold;" + 
        		"  -fx-background-color: #4C1919;" + 
        		"  -fx-background-size: 13px 13px, 29px 29px, 37px 37px, 53px 53px;" +
        		"  -fx-background-radius: 5px;";
    }
}
