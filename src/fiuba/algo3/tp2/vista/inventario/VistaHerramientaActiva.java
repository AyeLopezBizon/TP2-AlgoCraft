package fiuba.algo3.tp2.vista.inventario;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;

public class VistaHerramientaActiva implements Observer {
	
	private Herramienta herramientaActiva;
	private ContenedorHerramientaActiva contenedorHerramientaActiva;
	
	
	public VistaHerramientaActiva(ContenedorHerramientaActiva contenedorHerramientaActiva) {
		this.contenedorHerramientaActiva = contenedorHerramientaActiva;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals("equipar")) {
			
			herramientaActiva = (Herramienta)parametros[1];
			contenedorHerramientaActiva.dibujar(herramientaActiva);
			herramientaActiva.addObserver(this);
			
		} else if(accion.equals("desequipar")) {
			
			contenedorHerramientaActiva.dibujar(null);
			herramientaActiva.deleteObserver(this);
			
		} else if(accion.equals("reducirDurabilidad")) {
			contenedorHerramientaActiva.dibujar(herramientaActiva);
		}
	}
}
