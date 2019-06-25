package fiuba.algo3.tp2.vista.terreno;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.notificacion.Notificacion;
import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import fiuba.algo3.tp2.vista.ContenedorCasillero;
import fiuba.algo3.tp2.vista.ocupanteTerreno.Vista;

public class VistaCasilleroTerreno implements Observer {
	
	private OcupanteTerreno ocupanteTerreno;
	private VistaOcupanteTerreno vistaOcupanteTerreno;
	private ContenedorCasilleroTerreno contenedorCasilleroTerreno;
	
	public VistaCasilleroTerreno(ContenedorCasilleroTerreno contenedorCasilleroTerreno) {
		this.contenedorCasilleroTerreno = contenedorCasilleroTerreno;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals(Notificacion.OCUPAR_CASILLERO)) {
			try {
				
				ocupanteTerreno = (OcupanteTerreno)parametros[1];
				
				String nombreClaseVista = Vista.obtenerNombreClaseVistaParaOcupanteTerreno(ocupanteTerreno.getClass().getSimpleName());
				vistaOcupanteTerreno = (VistaOcupanteTerreno) Class.forName(nombreClaseVista)
						.getDeclaredConstructor(ContenedorCasillero.class, OcupanteTerreno.class)
						.newInstance(contenedorCasilleroTerreno, ocupanteTerreno);
				
				ocupanteTerreno.addObserver(vistaOcupanteTerreno);
				vistaOcupanteTerreno.dibujar();
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else if(accion.equals(Notificacion.DESOCUPAR_CASILLERO)){
			ocupanteTerreno.removeObserver(vistaOcupanteTerreno);
			contenedorCasilleroTerreno.limpiarCasillero();
		}
	}
}
