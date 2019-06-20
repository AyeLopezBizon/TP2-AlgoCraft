package fiuba.algo3.tp2.vista.ocupanteTerreno;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaCasilleroTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaOcupanteTerreno;
import fiuba.algo3.tp2.vista.terreno.VistaTerreno;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class VistaJugador implements VistaOcupanteTerreno {

	private VistaCasilleroTerreno vistaCasilleroTerreno;
	private Jugador jugador;
	
	
	public VistaJugador(VistaCasilleroTerreno vistaCasilleroTerreno, OcupanteTerreno ocupanteTerreno) {
		this.vistaCasilleroTerreno = vistaCasilleroTerreno;
		this.jugador = (Jugador)ocupanteTerreno;
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dibujar() {
		vistaCasilleroTerreno.setBackground(obtenerImagen(jugador));
	}

	private Background obtenerImagen(Jugador jugador) {
		
		String nombreImagen = jugador.getClass().getSimpleName() + ".png";

		String imagePath = "file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/" + nombreImagen;

		Image imagen = new Image(imagePath,
				VistaTerreno.TAMANIO_NODO,
				VistaTerreno.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		System.out.println(imagePath);
		return new Background(fondo);
	}
}
