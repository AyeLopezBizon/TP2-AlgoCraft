package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.herramienta.creador.NoSePuedeInicializarMesaDeTrabajoException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.vista.inventario.VistaInventario;

public class AccionUsuarioAbrirInventario implements AccionUsuario {
	
	Inventario inventario;
	
	public AccionUsuarioAbrirInventario(Inventario inventarios){
		this.inventario=inventario;
	}
	
	@Override
	public void ejecutar()  {
		VistaInventario vista = new VistaInventario(inventario);
		try {
			vista.mostrarInventario();
		} catch (NoSePuedeInicializarMesaDeTrabajoException e) {
			// TODO Auto-generated catch block
		}

	}

}
