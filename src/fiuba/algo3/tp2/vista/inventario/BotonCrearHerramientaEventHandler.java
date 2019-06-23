package fiuba.algo3.tp2.vista.inventario;

import fiuba.algo3.tp2.modelo.herramienta.Herramienta;
import fiuba.algo3.tp2.modelo.herramienta.creador.*;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.jugador.inventario.InventarioLlenoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.NoSePudoAlmacenarItemException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearHerramientaEventHandler implements EventHandler<ActionEvent> {

	private final MesaDeTrabajo mesaDeTrabajo;
	private final Inventario inventario;

	public BotonCrearHerramientaEventHandler(Inventario inventario, MesaDeTrabajo mesaDeTrabajo) {
		this.inventario = inventario;
		this.mesaDeTrabajo = mesaDeTrabajo;
	}

	@Override
	public void handle(ActionEvent actionEvent) {

		CreadorHerramienta creadorHerramienta = null;

		try {
			creadorHerramienta = new CreadorHerramienta();
		} catch (NoSePuedeInicializarMesaDeTrabajoException e) {
			e.printStackTrace();
		}

		Herramienta herramienta;

		try{
			herramienta = creadorHerramienta.crearHerramienta(mesaDeTrabajo);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			inventario.almacenar(herramienta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
