package fiuba.algo3.tp2.unidadMaterial;

import fiuba.algo3.tp2.material.UnidadMaterialVacio;

public class UnidadMetal extends UnidadMaterial {

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
		return true;
	}

	@Override
	public boolean esIgualA(UnidadDiamante otroMaterial) {
		return false;
	}

	@Override
	public boolean esIgualA(UnidadMaterialVacio otroMaterial) {
		return false;
	}
}
