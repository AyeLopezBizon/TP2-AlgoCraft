package fiuba.algo3.tp2.vista.juego;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorJuego extends BorderPane {
	
	
    public ContenedorJuego(Stage stage, BarraDeMenu barraDeMenu, ContenedorPrincipal contenedorPrincipal) {
    	
    	this.setTop(barraDeMenu);
        this.setCenter(contenedorPrincipal);
    }
}
