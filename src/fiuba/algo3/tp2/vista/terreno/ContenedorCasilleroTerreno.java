package fiuba.algo3.tp2.vista.terreno;

import fiuba.algo3.tp2.vista.ContenedorCasillero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContenedorCasilleroTerreno extends ContenedorCasillero {
	
	private ImageView imageView;
	
	public ContenedorCasilleroTerreno() {
		
	    imageView = new ImageView();
	    imageView.fitWidthProperty().bind(widthProperty());
	    imageView.fitHeightProperty().bind(heightProperty());
	    
	    getChildren().add(imageView);
	}

	public void limpiarCasillero() {
		
		imageView.setImage(null);
		setBackground(null);
	}

	@Override
	public void dibujar(Image imagen) {
		imageView.setImage(imagen);
	}
}
