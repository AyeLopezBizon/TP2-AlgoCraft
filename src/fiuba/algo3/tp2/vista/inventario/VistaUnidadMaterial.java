package fiuba.algo3.tp2.vista.inventario;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaUnidadMaterial implements VistaAlmacenable {

	private VistaCasilleroInventario vistaCasilleroInventario;
	private UnidadMaterial unidadMaterial;
	private ImageView imageView;
	private Image imagenUnidadMaterial;
	

	public VistaUnidadMaterial(VistaCasilleroInventario vistaCasilleroInventario, Almacenable almacenable) {
		
		this.vistaCasilleroInventario = vistaCasilleroInventario;
		this.unidadMaterial = (UnidadMaterial)almacenable;
		this.imagenUnidadMaterial = obtenerImagenUnidadMaterial();
		
        imageView = new ImageView();
        imageView.fitWidthProperty().bind(vistaCasilleroInventario.widthProperty());
        imageView.fitHeightProperty().bind(vistaCasilleroInventario.heightProperty());
        
        vistaCasilleroInventario.getChildren().add(imageView);
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
