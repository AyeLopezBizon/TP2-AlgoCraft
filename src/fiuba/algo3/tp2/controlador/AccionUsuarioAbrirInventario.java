package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.vista.inventario.ContenedorInventario;

public class AccionUsuarioAbrirInventario implements AccionUsuario {
	
	private static boolean mostrarInventario = false;
	private ContenedorInventario contenedorInventario;
	
	public AccionUsuarioAbrirInventario(ContenedorInventario contenedorInventario){
		this.contenedorInventario = contenedorInventario;
	}
	
	@Override
	public void ejecutar()  {
		mostrarInventario = !mostrarInventario;
		contenedorInventario.setVisible(mostrarInventario);
	}
}
