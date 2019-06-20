package fiuba.algo3.tp2.modelo.material;

import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadDiamante;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMadera;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMaterial;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadMetal;
import fiuba.algo3.tp2.modelo.unidadMaterial.UnidadPiedra;

public class UnidadMaterialVacio extends UnidadMaterial {

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
		return false;
	}

	@Override
	public boolean esIgualA(UnidadMaterialVacio otroMaterial) {
		return true;
	}
	
	@Override
	public boolean esVacio() {
		return true;
	}
}
