package fiuba.algo3.tp2.vista.juego;

import fiuba.algo3.tp2.vista.terreno.ContenedorTerreno;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorJuego extends BorderPane {
	
	
    public ContenedorJuego(Stage stage, BarraDeMenu barraDeMenu, ContenedorTerreno contenedorTerreno) {
    	
    	this.setTop(barraDeMenu);
        this.setCenter(contenedorTerreno);
    }
}
