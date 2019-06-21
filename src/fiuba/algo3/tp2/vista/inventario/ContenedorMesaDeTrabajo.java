package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajoVacia;
import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ContenedorMesaDeTrabajo extends GridPane{
	
	private final int TAMANIO=50;
	
	public ContenedorMesaDeTrabajo() throws NoSePuedeInicializarMesaDeTrabajoException{
	
		super();
		
		this.setGridLinesVisible(true);
		
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		for (int i = 0; i < mesaDeTrabajo.getCantidadDeFilas(); i++) {
            RowConstraints row = new RowConstraints(TAMANIO);
            this.getRowConstraints().add(row);
        }
        for (int i = 0; i < mesaDeTrabajo.getCantidadDeColumnas(); i++) {
            ColumnConstraints col = new ColumnConstraints(TAMANIO);
            this.getColumnConstraints().add(col);
        }
	}
}
