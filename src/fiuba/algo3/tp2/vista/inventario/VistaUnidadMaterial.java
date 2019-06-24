package fiuba.algo3.tp2.vista.inventario;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VistaUnidadMaterial implements VistaAlmacenable {
	
	private UnidadMaterial unidadMaterial;
	private ImageView imageView;
	private Image imagenUnidadMaterial;
	

	public VistaUnidadMaterial(Pane contenedor, Almacenable almacenable) {
		
		this.unidadMaterial = (UnidadMaterial)almacenable;
		try {
			this.imagenUnidadMaterial = obtenerImagenUnidadMaterial();
		}catch(Exception e) {
			this.imagenUnidadMaterial = null;
		}
		
        imageView = new ImageView();
        imageView.fitWidthProperty().bind(contenedor.widthProperty());
        imageView.fitHeightProperty().bind(contenedor.heightProperty());
        
        contenedor.getChildren().add(imageView);
	}


	private Image obtenerImagenUnidadMaterial() {
		String nombreImagen = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/inventario/" + unidadMaterial.getClass().getSimpleName() + ".png";
		return new Image(nombreImagen);
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dibujar() {

		imageView.setImage(imagenUnidadMaterial);
	}
}
