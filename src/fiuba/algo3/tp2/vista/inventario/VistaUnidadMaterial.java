package fiuba.algo3.tp2.vista.inventario;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.vista.ContenedorCasillero;
import fiuba.algo3.tp2.vista.Imagen;
import javafx.scene.image.Image;

public class VistaUnidadMaterial implements VistaAlmacenable {
	
	private ContenedorCasillero contenedor;
	private Image imagenUnidadMaterial;
	

	public VistaUnidadMaterial(ContenedorCasillero contenedor, Almacenable almacenable) {
		
		this.contenedor = contenedor;
		this.imagenUnidadMaterial = obtenerImagenUnidadMaterial(almacenable);
	}

	private Image obtenerImagenUnidadMaterial(Almacenable unidadMaterial) {
		return new Image(Imagen.obtenerImagenUnidadMaterial(unidadMaterial.getClass().getSimpleName()));
	}


	@Override
	public void update(Observable o, Object arg) {
	}
	
	@Override
	public void dibujar() {

		contenedor.dibujar(imagenUnidadMaterial);
	}
}