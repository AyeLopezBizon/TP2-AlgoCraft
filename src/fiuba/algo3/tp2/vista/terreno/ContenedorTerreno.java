package fiuba.algo3.tp2.vista.terreno;

import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ContenedorTerreno extends GridPane {
	
	private Integer cantidadColumnas;
	private Integer cantidadFilas;
	private Terreno terreno;
	
	public ContenedorTerreno(Terreno terreno) {
		
		this.cantidadColumnas = terreno.obtenerCantidadColumnas();
		this.cantidadFilas = terreno.obtenerCantidadFilas();
		this.terreno = terreno;
		
    	setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
    	
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/fondo.jpg",
        		terreno.obtenerCantidadColumnas() * VistaTerreno.TAMANIO_NODO,
        		terreno.obtenerCantidadFilas() * VistaTerreno.TAMANIO_NODO,
        		false,
        		true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(imagenDeFondo));
        
        dibujarTerreno();
	}
	
	public void dibujarTerreno() {
		
		for (int i = 0; i < terreno.obtenerCantidadFilas(); i++) {
            RowConstraints row = new RowConstraints();
            row.percentHeightProperty().set(5);
            getRowConstraints().add(row);
        }
        for (int i = 0; i < terreno.obtenerCantidadColumnas(); i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.percentWidthProperty().set(3);
            getColumnConstraints().add(col);
        }
        
        for (int i = 1 ; i <= terreno.obtenerCantidadColumnas() ; i++) {
            for (int j = 1; j <= terreno.obtenerCantidadFilas(); j++) {
            	
	    		Casillero<OcupanteTerreno> casilleroTerreno;
				try {
					casilleroTerreno = terreno.obtenerCasillero(new Posicion(i, j));
		        	VistaCasilleroTerreno vista = new VistaCasilleroTerreno();
		        	casilleroTerreno.addObserver(vista);
		        	add(vista, i-1, cantidadColumnas-j);
				} catch (CasilleroNoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
	}

}
