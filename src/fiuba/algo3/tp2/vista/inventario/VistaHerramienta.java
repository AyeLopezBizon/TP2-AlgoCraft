package fiuba.algo3.tp2.vista.inventario;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.vista.ContenedorCasillero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaHerramienta implements VistaAlmacenable {

	private ContenedorCasillero contenedor;
	private Herramienta herramienta;
	private ImageView imageView;
	private Image imagenHerramienta;
	

	public VistaHerramienta(ContenedorCasillero contenedor, Almacenable almacenable) {
		
		this.contenedor = contenedor;
		this.herramienta = (Herramienta)almacenable;
		this.imagenHerramienta = obtenerImagenHerramienta();
		
        imageView = new ImageView();
        imageView.fitWidthProperty().bind(contenedor.widthProperty());
        imageView.fitHeightProperty().bind(contenedor.heightProperty());
        
        contenedor.getChildren().add(imageView);
	}


	private Image obtenerImagenHerramienta() {
		String nombreImagen = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/inventario/" + herramienta.getNombre() + ".png";
		return new Image(nombreImagen);
	}


	@Override
	public void update(Observable o, Object arg) {
	}
	
	@Override
	public void dibujar() {

		contenedor.dibujar(imagenHerramienta);
	}
}
