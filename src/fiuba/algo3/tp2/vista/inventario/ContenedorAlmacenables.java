package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ContenedorAlmacenables extends GridPane{
	
	private final int TAMANIO = 50;
	private Inventario inventario;
	private int cantFilas;
	private int cantColumnas;
	
	public ContenedorAlmacenables(Inventario inventario) {
		this.inventario = inventario;
		this.cantFilas = 5;
		this.cantColumnas =10;
		
		this.setGridLinesVisible(true);
		
		for (int i = 0; i < cantFilas; i++) {
            RowConstraints row = new RowConstraints(TAMANIO);
            this.getRowConstraints().add(row);
        }
        for (int i = 0; i < cantColumnas; i++) {
            ColumnConstraints col = new ColumnConstraints(TAMANIO);
            this.getColumnConstraints().add(col);
        }
	}
}
