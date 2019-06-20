package fiuba.algo3.tp2.vista.terreno;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.terreno.OcupanteTerreno;
import javafx.scene.layout.Pane;

public class VistaCasilleroTerreno extends Pane implements Observer {
	
	private OcupanteTerreno ocupanteTerreno;
	VistaOcupanteTerreno vistaOcupanteTerreno;
	
	@Override
	public void update(Observable o, Object arg) {
		
		Object[] parametros = ((Object[])arg);
		String accion = (String)parametros[0];
		
		if(accion.equals("ocuparCasillero")) {
			try {
				
				ocupanteTerreno = (OcupanteTerreno)parametros[1];
				
				String nombreClaseVista = "fiuba.algo3.tp2.vista.ocupanteTerreno.Vista" + ocupanteTerreno.getClass().getSimpleName();
				vistaOcupanteTerreno = (VistaOcupanteTerreno) Class.forName(nombreClaseVista)
						.getDeclaredConstructor(VistaCasilleroTerreno.class, OcupanteTerreno.class)
						.newInstance(this, ocupanteTerreno);
	
				ocupanteTerreno.addObserver(vistaOcupanteTerreno);
				vistaOcupanteTerreno.dibujar();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(accion.equals("desocuparCasillero")){
			limpiarCasillero();
		}
	}

	private void limpiarCasillero() {
		ocupanteTerreno.removeObserver(vistaOcupanteTerreno);
		getChildren().clear();
		setBackground(null);
	}
}
