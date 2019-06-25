package fiuba.algo3.tp2.vista.inventario;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;
import fiuba.algo3.tp2.vista.ContenedorCasillero;

public class VistaCasilleroMesaDeTrabajo implements Observer {
	
	private VistaUnidadMaterial vistaUnidadMaterial;
	private ContenedorCasilleroMesaDeTrabajo contenedorCasilleroMesaDeTrabajo;
	

	public VistaCasilleroMesaDeTrabajo(ContenedorCasilleroMesaDeTrabajo contenedorCasilleroMesaDeTrabajo) {
		
		this.contenedorCasilleroMesaDeTrabajo = contenedorCasilleroMesaDeTrabajo;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals("ocuparCasillero")) {
			
			try {
				
				UnidadMaterial unidadMaterial = (UnidadMaterial)parametros[1];
				
				String nombreClaseVista = "fiuba.algo3.tp2.vista.inventario.Vista" + unidadMaterial.getClass().getSimpleName();
				vistaUnidadMaterial = (VistaUnidadMaterial) Class.forName(nombreClaseVista)
						.getDeclaredConstructor(ContenedorCasillero.class, Almacenable.class)
						.newInstance(contenedorCasilleroMesaDeTrabajo, unidadMaterial);
				
				vistaUnidadMaterial.dibujar();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(accion.equals("desocuparCasillero")){
			contenedorCasilleroMesaDeTrabajo.limpiarCasillero();
		}
	}
}
