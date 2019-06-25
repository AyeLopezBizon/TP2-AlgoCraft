package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ContenedorAlmacenables extends GridPane {
	
	private final int TAMANIO = 50;
	
	public ContenedorAlmacenables(Jugador jugador) {
		
		try {
			Inventario inventario = jugador.obtenerInventario();
			this.setGridLinesVisible(true);
			
	        RowConstraints row = new RowConstraints(TAMANIO);
	        this.getRowConstraints().add(row);
	        
	        for (int i = 0; i < inventario.obtenerCapacidad(); i++) {
	            ColumnConstraints col = new ColumnConstraints(TAMANIO);
	            this.getColumnConstraints().add(col);
	        }
	        for (int i = 1 ; i <= inventario.obtenerCapacidad() ; i++) {
        		
    			Casillero<Almacenable> casilleroInventario = inventario.obtenerCasillero(i);
    			ContenedorCasilleroInventario contenedorCasilleroInventario = 
    					new ContenedorCasilleroInventario(jugador, i);
	        	VistaCasilleroInventario vista = new VistaCasilleroInventario(contenedorCasilleroInventario);
	        	casilleroInventario.addObserver(vista);
	        	add(contenedorCasilleroInventario, i-1, 0);
	        	try {
	        		vista.dibujar(casilleroInventario.obtenerValor());
	        	} catch (CasilleroVacioException e) {
	    			// Hay que dejar que siga iterando y dibujando lo que pueda
	    		}
	        }
		} catch(CasilleroNoEncontradoException e) {
			e.printStackTrace();
		}
	}
}
