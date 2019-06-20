package fiuba.algo3.tp2.vista.juego;

import fiuba.algo3.tp2.vista.terreno.ContenedorTerreno;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorJuego extends BorderPane {
	
	private Stage stage;
	private BarraDeMenu barraDeMenu;
	
	
    public ContenedorJuego(Stage stage, ContenedorTerreno contenedorTerreno) {
    	
    	this.stage = stage;
    	
        this.setMenu();
        this.setCenter(contenedorTerreno);
    }

	public void setMenu() {
    	
        barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
    }

	public BarraDeMenu getBarraDeMenu() {
		return barraDeMenu;
	}
}
