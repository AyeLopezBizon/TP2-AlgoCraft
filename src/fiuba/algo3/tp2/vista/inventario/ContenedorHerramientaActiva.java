package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
		
		setAlignment(Pos.BOTTOM_CENTER);
		setPrefWidth(100);
		setMaxWidth(100);
		setPrefHeight(100);
		setMaxHeight(100);
		
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
		
		Pane imagenHerramienta = new Pane();
		
		
		imageView = new ImageView();
        imageView.fitWidthProperty().bind(imagenHerramienta.widthProperty());
        imageView.fitHeightProperty().bind(imagenHerramienta.heightProperty());
        imagenHerramienta.getChildren().add(imageView);
        
        getChildren().add(imagenHerramienta);
        barraDurabilidad = new BarraDurabilidad();
        barraDurabilidad.prefWidthProperty().bind(widthProperty());
        
        setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		            	try {
							jugador.desequipar();
						} catch (InventarioLlenoException | NoSePudoAlmacenarItemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        }
		    }
		});
	}

	public void dibujar(Herramienta herramientaActiva) {
		
		getChildren().remove(barraDurabilidad);
		if(herramientaActiva == null) {
			imageView.setImage(null);
		} else {
			imageView.setImage(new Image("file:src/fiuba/algo3/tp2/vista/resources/imagenes/inventario/" + herramientaActiva.getNombre() + ".png"));
			barraDurabilidad.dibujar(herramientaActiva.getMaximaDurabilidad().doubleValue(), 
					herramientaActiva.getDurabilidad().doubleValue());
			getChildren().add(barraDurabilidad);
		}
	}
}
