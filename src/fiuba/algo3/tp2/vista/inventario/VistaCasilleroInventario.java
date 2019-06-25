package fiuba.algo3.tp2.vista.inventario;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.vista.ContenedorCasillero;

public class VistaCasilleroInventario implements Observer {

	private Almacenable almacenable;
	private VistaAlmacenable vistaAlmacenable;
	private ContenedorCasilleroInventario contenedorCasilleroInventario;

	public VistaCasilleroInventario(ContenedorCasilleroInventario contenedorCasilleroInventario) {
		this.contenedorCasilleroInventario = contenedorCasilleroInventario;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals("ocuparCasillero")) {
			
			dibujar((Almacenable)parametros[1]);
			
		}else if(accion.equals("desocuparCasillero")){
			
			almacenable.deleteObserver(vistaAlmacenable);
			contenedorCasilleroInventario.limpiarCasillero();
		}
	}
	
	public void dibujar(Almacenable almacenable) {
		
		try {
			
			this.almacenable = almacenable;
			String nombreClaseVista = "fiuba.algo3.tp2.vista.inventario.Vista" + almacenable.getClass().getSimpleName();
		
			vistaAlmacenable = (VistaAlmacenable) Class.forName(nombreClaseVista)
					.getDeclaredConstructor(ContenedorCasillero.class, Almacenable.class)
					.newInstance(contenedorCasilleroInventario, almacenable);
			
			almacenable.addObserver(vistaAlmacenable);
			
			vistaAlmacenable.dibujar();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

}
