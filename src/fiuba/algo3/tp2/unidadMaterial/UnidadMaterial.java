package fiuba.algo3.tp2.unidadMaterial;

import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.material.UnidadMaterialVacio;

public abstract class UnidadMaterial implements Almacenable {
	
	public abstract boolean esIgualA(UnidadMaterial otroMaterial);
	
	public abstract boolean esIgualA(UnidadMadera otroMaterial);
	
	public abstract boolean esIgualA(UnidadPiedra otroMaterial);
	
	public abstract boolean esIgualA(UnidadMetal otroMaterial);
	
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
