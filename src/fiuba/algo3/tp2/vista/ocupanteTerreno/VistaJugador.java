package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.sonido.ReproductorSonido;
import fiuba.algo3.tp2.vista.terreno.VistaCasilleroTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaTerreno;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class VistaJugador extends Vista implements VistaOcupanteTerreno {

	private VistaCasilleroTerreno vistaCasilleroTerreno;
	private Jugador jugador;
	
	private Image imagenJugadorPasivo;
	private Image imagenJugadorGolpeando;
	private FadeTransition transicionGolpeandoAPasivo;
	
	private ImageView imageView;
	
	public VistaJugador(VistaCasilleroTerreno vistaCasilleroTerreno, OcupanteTerreno ocupanteTerreno) {
		
		this.vistaCasilleroTerreno = vistaCasilleroTerreno;
		this.jugador = (Jugador)ocupanteTerreno;
		
		imagenJugadorPasivo = obtenerImagenJugadorPasivo();
        imagenJugadorGolpeando = obtenerImagenJugadorGolpeando();
        imageView = new ImageView();
        imageView.fitWidthProperty().bind(vistaCasilleroTerreno.widthProperty());
        imageView.fitHeightProperty().bind(vistaCasilleroTerreno.heightProperty());
		
        transicionGolpeandoAPasivo = crearTransicionGolpeandoAPasivo();
        
		this.vistaCasilleroTerreno.getChildren().add(imageView);
	}
	
	
   private FadeTransition crearTransicionGolpeandoAPasivo(){
    	
        FadeTransition fadeOutTransition 
                = new FadeTransition(Duration.seconds(0.1), imageView);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(1.0);
        fadeOutTransition.setOnFinished(new EventHandler<ActionEvent>(){
        	 
            @Override
            public void handle(ActionEvent arg0) {
            	imageView.setImage(imagenJugadorPasivo);
            }
             
        });
        
        return fadeOutTransition;
    }


	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals("lanzarGolpe")) {
			imageView.setImage(imagenJugadorGolpeando);
			transicionGolpeandoAPasivo.play();
		} else if (accion.equals("mover")) {
			ReproductorSonido.reproducir("MOVER");
		}
	}

	@Override
	public void dibujar() {
		imageView.setImage(imagenJugadorPasivo);
	}

	private Image obtenerImagenJugadorGolpeando() {
		
		String nombreImagen = jugador.getClass().getSimpleName() + "Golpeando.png";
		
		String imagePath = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/" + nombreImagen;

		Image imagen = new Image(imagePath,
				VistaTerreno.TAMANIO_NODO,
				VistaTerreno.TAMANIO_NODO,
				false,
				true);
		return imagen;
	}
	
	private Image obtenerImagenJugadorPasivo() {
		
		String nombreImagen = jugador.getClass().getSimpleName() + ".png";
		
		String imagePath = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/" + nombreImagen;

		Image imagen = new Image(imagePath,
				VistaTerreno.TAMANIO_NODO,
				VistaTerreno.TAMANIO_NODO,
				false,
				true);
		
		return imagen;
	}
}