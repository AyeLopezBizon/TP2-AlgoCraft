package fiuba.algo3.tp2.vista.inventario;

import java.math.BigDecimal;

import fiuba.algo3.tp2.controlador.inventario.ContenedorHerramientaActivaOnDoubleClickHandler;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ContenedorHerramientaActiva extends StackPane {

	private BarraDurabilidad barraDurabilidad;
	private ImageView imageView;
	
	
	public ContenedorHerramientaActiva(Jugador jugador) {
		
		setearFondoYDistribucionComponentes();
		
		agregarContenedorImagenHerramientaActiva();
		crearBarraDeDurabilidad();
		
        setOnMouseClicked(new ContenedorHerramientaActivaOnDoubleClickHandler(jugador));
	}

	private void crearBarraDeDurabilidad() {
		
        barraDurabilidad = new BarraDurabilidad();
        barraDurabilidad.prefWidthProperty().bind(widthProperty());
	}

	private void agregarContenedorImagenHerramientaActiva() {
		
		Pane imagenHerramienta = new Pane();
		
		imageView = new ImageView();
        imageView.fitWidthProperty().bind(imagenHerramienta.widthProperty());
        imageView.fitHeightProperty().bind(imagenHerramienta.heightProperty());
        imagenHerramienta.getChildren().add(imageView);
        
        getChildren().add(imagenHerramienta);
	}

	private void setearFondoYDistribucionComponentes() {
		
		setAlignment(Pos.BOTTOM_CENTER);
		setPrefWidth(100);
		setMaxWidth(100);
		setPrefHeight(100);
		setMaxHeight(100);
		
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, new BorderWidths(4))));
	}

	public void dibujar(Image imagen) {
		
		imageView.setImage(imagen);
	}

	public void quitarBarraDurabilidad() {
		getChildren().remove(barraDurabilidad);
	}

	public void dibujarBarraDurabilidad(BigDecimal durabilidad, BigDecimal maximaDurabilidad) {
		
		getChildren().remove(barraDurabilidad);
		barraDurabilidad.dibujar(maximaDurabilidad.doubleValue(), durabilidad.doubleValue());
		getChildren().add(barraDurabilidad);
	}
}
