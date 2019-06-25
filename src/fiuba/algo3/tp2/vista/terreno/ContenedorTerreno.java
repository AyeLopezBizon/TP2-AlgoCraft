package fiuba.algo3.tp2.vista.terreno;

import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import fiuba.algo3.tp2.vista.Imagen;
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
	
	private static final Integer PORCENTAJE_ANCHO_CASILLERO = 3;
	private static final Integer PORCENTAJE_ALTO_CASILLERO = 5;
	
	public ContenedorTerreno(Terreno terreno) throws NoSePudoDibujarTerrenoException {
		
		setImagenFondoYDistribucionComponentes(terreno);
    	
        dibujarTerreno(terreno);
	}
	
	private void setImagenFondoYDistribucionComponentes(Terreno terreno) {
		
		setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
    	
        Image imagen = new Image(Imagen.FONDO_TERRENO,
        		terreno.obtenerCantidadColumnas() * VistaTerreno.TAMANIO_NODO,
        		terreno.obtenerCantidadFilas() * VistaTerreno.TAMANIO_NODO,
        		false,
        		true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(imagenDeFondo));
	}

	private void dibujarTerreno(Terreno terreno) throws NoSePudoDibujarTerrenoException {
		
		try {
			
			Integer cantidadColumnas = terreno.obtenerCantidadColumnas();
			
			for (int i = 0; i < terreno.obtenerCantidadFilas(); i++) {
	            RowConstraints row = new RowConstraints();
	            row.percentHeightProperty().set(PORCENTAJE_ALTO_CASILLERO);
	            getRowConstraints().add(row);
	        }
	        for (int i = 0; i < terreno.obtenerCantidadColumnas(); i++) {
	            ColumnConstraints col = new ColumnConstraints();
	            col.percentWidthProperty().set(PORCENTAJE_ANCHO_CASILLERO);
	            getColumnConstraints().add(col);
	        }
	        
	        for (int i = 1 ; i <= terreno.obtenerCantidadColumnas() ; i++) {
	            for (int j = 1; j <= terreno.obtenerCantidadFilas(); j++) {
	            	
		    		Casillero<OcupanteTerreno> casilleroTerreno = terreno.obtenerCasillero(new Posicion(i, j));
		    		ContenedorCasilleroTerreno contenedorCasilleroTerreno = new ContenedorCasilleroTerreno();
		        	VistaCasilleroTerreno vista = new VistaCasilleroTerreno(contenedorCasilleroTerreno);
		        	casilleroTerreno.addObserver(vista);
		        	add(contenedorCasilleroTerreno, i - 1, cantidadColumnas - j);
	            }
	        }
		} catch(CasilleroNoEncontradoException e) {
			throw new NoSePudoDibujarTerrenoException(e);
		}
	}

}
