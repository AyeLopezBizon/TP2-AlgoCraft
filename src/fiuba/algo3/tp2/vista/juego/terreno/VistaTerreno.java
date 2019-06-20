package fiuba.algo3.tp2.vista.juego.terreno;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.modelo.terreno.Terreno;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class VistaTerreno implements Observer {
	
	public static int TAMANIO_NODO = 30;
	
	private Terreno terreno;
	private ContenedorTerreno contenedorTerreno;

	
	public VistaTerreno(Terreno terreno, ContenedorTerreno contenedorTerreno) {
		
		this.terreno = terreno;
		this.contenedorTerreno = contenedorTerreno;
	}

	public void dibujarTerreno() {
		
		for (int i = 0; i < terreno.obtenerCantidadFilas(); i++) {
            RowConstraints row = new RowConstraints(TAMANIO_NODO);
            contenedorTerreno.getRowConstraints().add(row);
        }
        for (int i = 0; i < terreno.obtenerCantidadColumnas(); i++) {
            ColumnConstraints col = new ColumnConstraints(TAMANIO_NODO);
            contenedorTerreno.getColumnConstraints().add(col);
        }
        
        for (int i = 0 ; i < terreno.obtenerCantidadColumnas() ; i++) {
            for (int j = 0; j < terreno.obtenerCantidadFilas(); j++) {
            	
            	CasilleroTerreno casilleroTerreno = new CasilleroTerreno();
            	contenedorTerreno.add(casilleroTerreno, i, j);
            }
        }
	}

	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println((String)((Object[])arg)[0]);
		
		if(((String)((Object[])arg)[0]).equals("ocuparCasillero")) {
			contenedorTerreno.ocuparCasillero((OcupanteTerreno)((Object[])arg)[1], (Posicion)((Object[])arg)[2]);
		}else {
			contenedorTerreno.desocuparCasillero((Posicion)((Object[])arg)[1]);
		}
		
	}
}