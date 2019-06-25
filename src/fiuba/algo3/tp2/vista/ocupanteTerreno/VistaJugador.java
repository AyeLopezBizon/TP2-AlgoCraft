package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.notificacion.Notificacion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.ContenedorCasillero;
import fiuba.algo3.tp2.vista.Imagen;
import fiuba.algo3.tp2.vista.sonido.ReproductorSonido;
import fiuba.algo3.tp2.vista.sonido.Sonido;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaTerreno;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class VistaJugador implements VistaOcupanteTerreno {

	private ContenedorCasillero contenedor;
	
	private Image imagenJugadorPasivo;
	private Image imagenJugadorGolpeando;
	private FadeTransition transicionGolpeandoAPasivo;
	
	public VistaJugador(ContenedorCasillero contenedor, OcupanteTerreno ocupanteTerreno) {
		
		this.contenedor = contenedor;
		
		imagenJugadorPasivo = obtenerImagenJugadorPasivo();
        imagenJugadorGolpeando = obtenerImagenJugadorGolpeando();
        transicionGolpeandoAPasivo = crearTransicionGolpeandoAPasivo();
	}
	
	private Image obtenerImagenJugadorGolpeando() {
		
		Image imagen = new Image(Imagen.IMAGEN_JUGADOR_GOLPEANDO,
				VistaTerreno.TAMANIO_NODO,
				VistaTerreno.TAMANIO_NODO,
				false,
				true);
		
		return imagen;
	}
	
	private Image obtenerImagenJugadorPasivo() {
		
		Image imagen = new Image(Imagen.IMAGEN_JUGADOR,
				VistaTerreno.TAMANIO_NODO,
				VistaTerreno.TAMANIO_NODO,
				false,
				true);
		
		return imagen;
	}
	
	private FadeTransition crearTransicionGolpeandoAPasivo(){
    	
        FadeTransition fadeOutTransition 
                = new FadeTransition(Duration.seconds(0.1), contenedor);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(1.0);
        fadeOutTransition.setOnFinished(new EventHandler<ActionEvent>(){
        	 
            @Override
            public void handle(ActionEvent arg0) {
            	contenedor.dibujar(imagenJugadorPasivo);
            }
        });
        
        return fadeOutTransition;
    }

	@Override
	public void dibujar() {
		contenedor.dibujar(imagenJugadorPasivo);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals(Notificacion.LANZAR_GOLPE)) {
			
			contenedor.dibujar(imagenJugadorGolpeando);
			transicionGolpeandoAPasivo.play();
			
		} else if (accion.equals(Notificacion.MOVER)) {
			
			ReproductorSonido.reproducir(Sonido.MOVER);
		}
	}
}