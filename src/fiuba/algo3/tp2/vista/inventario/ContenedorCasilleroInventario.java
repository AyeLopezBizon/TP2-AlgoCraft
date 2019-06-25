package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.controlador.inventario.ContenedorCasilleroInventarioOnDragDetected;
import fiuba.algo3.tp2.controlador.inventario.ContenedorCasilleroInventarioOnMouseClicked;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.vista.ContenedorCasillero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContenedorCasilleroInventario extends ContenedorCasillero {
	
	private ImageView imageView;
	

	public ContenedorCasilleroInventario(Jugador jugador, Integer numeroEspacioInventario) {
		
		setOnDragDetected(new ContenedorCasilleroInventarioOnDragDetected(this, numeroEspacioInventario));
		setOnMouseClicked(new ContenedorCasilleroInventarioOnMouseClicked(jugador, numeroEspacioInventario));
		
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
