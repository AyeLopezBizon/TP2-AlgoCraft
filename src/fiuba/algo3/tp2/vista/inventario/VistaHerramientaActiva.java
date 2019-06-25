package fiuba.algo3.tp2.vista.inventario;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.notificacion.Notificacion;
import fiuba.algo3.tp2.vista.Imagen;
import javafx.scene.image.Image;

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
		
		if(accion.equals(Notificacion.EQUIPAR)) {
			
			herramientaActiva = (Herramienta)parametros[1];
			
			contenedorHerramientaActiva.dibujar(
					new Image(Imagen.obtenerImagenHerramienta(herramientaActiva.getNombre())));
			
			contenedorHerramientaActiva.dibujarBarraDurabilidad(herramientaActiva.getDurabilidad(), 
					herramientaActiva.getMaximaDurabilidad());
			
			herramientaActiva.addObserver(this);
			
		} else if(accion.equals(Notificacion.DESEQUIPAR)) {
			
			contenedorHerramientaActiva.dibujar(null);
			contenedorHerramientaActiva.quitarBarraDurabilidad();
			
			herramientaActiva.deleteObserver(this);
			
		} else if(accion.equals(Notificacion.REDUCIR_DURABILIDAD_HERRAMIENTA)) {
			
			herramientaActiva = (Herramienta)parametros[1];
			
			contenedorHerramientaActiva.dibujarBarraDurabilidad(herramientaActiva.getDurabilidad(), 
					herramientaActiva.getMaximaDurabilidad());
			
		} else if(accion.equals(Notificacion.DESTRUIR_HERRAMIENTA)) {
			
			contenedorHerramientaActiva.dibujar(null);
			contenedorHerramientaActiva.quitarBarraDurabilidad();
			
			herramientaActiva.deleteObserver(this);
			herramientaActiva = null;
		}
	}
}
