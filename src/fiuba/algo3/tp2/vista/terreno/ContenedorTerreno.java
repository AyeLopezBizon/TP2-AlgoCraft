package fiuba.algo3.tp2.vista.terreno;

import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
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
		
    	//setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
    	
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/resources/imagenes/terreno/fondo.jpg",
        		terreno.obtenerCantidadColumnas() * VistaTerreno.TAMANIO_NODO,
        		terreno.obtenerCantidadFilas() * VistaTerreno.TAMANIO_NODO,
        		false,
        		true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(imagenDeFondo));
        
        dibujarTerreno();
	}
	
	public void dibujarTerreno() {
		
		for (int i = 0; i < terreno.obtenerCantidadFilas(); i++) {
            RowConstraints row = new RowConstraints(VistaTerreno.TAMANIO_NODO);
            getRowConstraints().add(row);
        }
        for (int i = 0; i < terreno.obtenerCantidadColumnas(); i++) {
            ColumnConstraints col = new ColumnConstraints(VistaTerreno.TAMANIO_NODO);
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
	/*
	public void ocuparCasillero(OcupanteTerreno ocupanteTerreno, Posicion posicion) {
		
		for(Node nodo : getChildren()) {
			if(nodo instanceof Pane && 
					new Posicion(GridPane.getColumnIndex(nodo) + 1, cantidadFilas - (GridPane.getRowIndex(nodo))).esIgualA(posicion)) {
				
				VistaOcupanteTerreno vista;
				try {
					String nombreClaseVista = "Vista" + ocupanteTerreno.getClass().getSimpleName();
					vista = (VistaOcupanteTerreno) Class.forName(nombreClaseVista).getDeclaredConstructor(Pane.class, OcupanteTerreno.class).newInstance(nodo, ocupanteTerreno);
					ocupanteTerreno.addObserver(vista);
					vista.dibujar();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
*/

}
