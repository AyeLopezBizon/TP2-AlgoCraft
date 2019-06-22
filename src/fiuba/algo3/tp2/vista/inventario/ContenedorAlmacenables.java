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

public class ContenedorAlmacenables extends GridPane{
	
	private final int TAMANIO = 50;
	private Inventario inventario;
	private int cantFilas;
	private int cantColumnas;
	
	public ContenedorAlmacenables(Jugador jugador, Inventario inventario) {
		this.inventario = inventario;
		this.cantFilas = 5;
		this.cantColumnas = 10;
		
		this.setGridLinesVisible(true);
		
		for (int i = 0; i < cantFilas; i++) {
            RowConstraints row = new RowConstraints(TAMANIO);
            this.getRowConstraints().add(row);
        }
        for (int i = 0; i < cantColumnas; i++) {
            ColumnConstraints col = new ColumnConstraints(TAMANIO);
            this.getColumnConstraints().add(col);
        }
        for (int i = 1 ; i <= inventario.obtenerCapacidad() ; i++) {
        	
    		Casillero<Almacenable> casilleroInventario;
			try {
				casilleroInventario = inventario.obtenerCasillero(i);
	        	VistaCasilleroInventario vista = new VistaCasilleroInventario();
	        	casilleroInventario.addObserver(vista);
	        	add(vista, i-1, 0);
	        	vista.dibujar(i, jugador, casilleroInventario.obtenerValor());
			} catch (CasilleroNoEncontradoException | CasilleroVacioException e) {
				// TODO Auto-generated catch block
			}
        }
	}
}
