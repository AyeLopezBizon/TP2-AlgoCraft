package fiuba.algo3.tp2.controlador.inventario;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.CreadorHerramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.MaterialesMalPosicionadosException;
import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.modelo.matriz.casillero.CasilleroVacioException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearEventHandler implements EventHandler<ActionEvent> {

	private Inventario inventario;
	private CreadorHerramienta creadorHerramienta;
	private MesaDeTrabajo mesaDeTrabajo;
	

	public BotonCrearEventHandler(Inventario inventario, MesaDeTrabajo mesaDeTrabajo, CreadorHerramienta creadorHerramienta) {
		this.inventario = inventario;
		this.creadorHerramienta = creadorHerramienta;
		this.mesaDeTrabajo = mesaDeTrabajo;
	}

	@Override
	public void handle(ActionEvent event) {
		
		try {
			Herramienta herramienta = creadorHerramienta.crearHerramienta(mesaDeTrabajo);
			inventario.almacenar(herramienta);
		} catch (MaterialesMalPosicionadosException | InventarioLlenoException | NoSePudoAlmacenarItemException 
				| CasilleroVacioException | CasilleroNoEncontradoException | CasilleroOcupadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
