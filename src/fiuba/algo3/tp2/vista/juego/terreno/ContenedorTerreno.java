package fiuba.algo3.tp2.vista.juego.terreno;

import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.terreno.Terreno;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ContenedorTerreno extends GridPane {
	
	private Integer cantidadColumnas;
	private Integer cantidadFilas;
	
	
	public ContenedorTerreno(Terreno terreno) {
		
		this.cantidadColumnas = terreno.obtenerCantidadColumnas();
		this.cantidadFilas = terreno.obtenerCantidadFilas();
		
    	//setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
    	
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/fondo.jpg",
        		terreno.obtenerCantidadColumnas() * VistaTerreno.TAMANIO_NODO,
        		terreno.obtenerCantidadFilas() * VistaTerreno.TAMANIO_NODO,
        		false,
        		true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(imagenDeFondo));
        
	}

	public void ocuparCasillero(OcupanteTerreno ocupanteTerreno, Posicion posicion) {
		
		for(Node nodo : getChildren()) {
			if(nodo instanceof Pane && 
					new Posicion(GridPane.getColumnIndex(nodo) + 1, cantidadFilas - (GridPane.getRowIndex(nodo))).esIgualA(posicion)) {
				((Pane)nodo).setBackground(obtenerImagen(ocupanteTerreno));
			}
		}
	}
	
	public void desocuparCasillero(Posicion posicion) {
		for(Node nodo : getChildren()) {
			if(nodo instanceof Pane && 
					new Posicion(GridPane.getColumnIndex(nodo) + 1, cantidadFilas - (GridPane.getRowIndex(nodo))).esIgualA(posicion)) {
				((Pane)nodo).setBackground(null);
			}
		}
	}

	private Background obtenerImagen(OcupanteTerreno ocupanteTerreno) {
		
		String nombreImagen = ocupanteTerreno.getClass().getSimpleName() + ".png";

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
