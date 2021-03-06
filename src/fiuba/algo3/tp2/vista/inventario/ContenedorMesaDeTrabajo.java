package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.matriz.casillero.Casillero;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ContenedorMesaDeTrabajo extends GridPane{
	
	private final int TAMANIO = 50;
	
	public ContenedorMesaDeTrabajo(Inventario inventario, MesaDeTrabajo mesaDeTrabajo) 
			throws NoSePuedeInicializarContenedorMesaDeTrabajo {
		
		try {
			
			setAlignment(Pos.CENTER_RIGHT);
			this.setGridLinesVisible(true);
			
			for (int i = 0; i < mesaDeTrabajo.getCantidadDeFilas(); i++) {
	            RowConstraints row = new RowConstraints(TAMANIO);
	            this.getRowConstraints().add(row);
	        }
	        for (int i = 0; i < mesaDeTrabajo.getCantidadDeColumnas(); i++) {
	            ColumnConstraints col = new ColumnConstraints(TAMANIO);
	            this.getColumnConstraints().add(col);
	        }
	        
	        for (int i = 1 ; i <= mesaDeTrabajo.getCantidadDeColumnas() ; i++) {
	        	for(int j = 1 ; j <= mesaDeTrabajo.getCantidadDeFilas() ; j++) {
	        		
	        		Posicion posicion = new Posicion(i, j);
					Casillero<UnidadMaterial> casilleroMesaDeTrabajo = mesaDeTrabajo.obtenerCasillero(posicion);
					
					ContenedorCasilleroMesaDeTrabajo contenedorCasilleroMesaDeTrabajo = 
							new ContenedorCasilleroMesaDeTrabajo(inventario, posicion, mesaDeTrabajo);
					VistaCasilleroMesaDeTrabajo vista = new VistaCasilleroMesaDeTrabajo(contenedorCasilleroMesaDeTrabajo);
					
		        	casilleroMesaDeTrabajo.addObserver(vista);
		        	add(contenedorCasilleroMesaDeTrabajo, i - 1, j - 1);
	        	}
	        }
	        
		} catch(CasilleroNoEncontradoException e) {
			throw new NoSePuedeInicializarContenedorMesaDeTrabajo(e);
		}
	}
}
