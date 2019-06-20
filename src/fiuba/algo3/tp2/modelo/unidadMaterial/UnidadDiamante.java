package fiuba.algo3.tp2.modelo.unidadMaterial;

import fiuba.algo3.tp2.modelo.material.UnidadMaterialVacio;

public class UnidadDiamante extends UnidadMaterial {

	@Override
	public boolean esIgualA(UnidadMaterial otroMaterial) {
		return otroMaterial.esIgualA(this);
	}

	@Override
	public boolean esIgualA(UnidadMadera otroMaterial) {
		return false;
	}

	@Override
	public boolean esIgualA(UnidadPiedra otroMaterial) {
		return false;
	}

	@Override
	public boolean esIgualA(UnidadMetal otroMaterial) {
		return false;
	}

	@Override
	public boolean esIgualA(UnidadDiamante otroMaterial) {
		return true;
	}

	@Override
	public boolean esIgualA(UnidadMaterialVacio otroMaterial) {
		return false;
	}
}
