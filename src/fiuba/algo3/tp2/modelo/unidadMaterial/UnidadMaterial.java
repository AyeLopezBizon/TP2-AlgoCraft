package fiuba.algo3.tp2.modelo.unidadMaterial;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.material.UnidadMaterialVacio;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public abstract class UnidadMaterial extends Observable implements Almacenable {
	
	private Integer numeroEspacioInventario;
	private Inventario inventario;
	
	
	public abstract boolean esIgualA(UnidadMaterial otroMaterial);
	
	public abstract boolean esIgualA(UnidadMadera otroMaterial);
	
	public abstract boolean esIgualA(UnidadPiedra otroMaterial);
	
	public abstract boolean esIgualA(UnidadMetal otroMaterial);
	
	@Override
	public void agregarAMesaDeTrabajo(MesaDeTrabajo mesaDeTrabajo, Posicion posicion) throws PosicionIncorrectaException, EspacioVacioException {
		
		mesaDeTrabajo.agregarMaterial(this, posicion);
		inventario.quitar(numeroEspacioInventario);
	}

	@Override
	public void almacenar(Inventario inventario, Integer numeroEspacioInventario) {
		this.inventario = inventario;
		this.numeroEspacioInventario = numeroEspacioInventario;
	}

	@Override
	public Integer obtenerNumeroEspacioInventario() {
		return numeroEspacioInventario;
	}

	public abstract boolean esIgualA(UnidadDiamante otroMaterial);

	public abstract boolean esIgualA(UnidadMaterialVacio otroMaterial);

	public boolean esVacio() {
		return false;
	}
	
	@Override
	public void equiparEn(Jugador jugador) {
		// No se puede equipar en jugador
	}
}
