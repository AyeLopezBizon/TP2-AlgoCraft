package fiuba.algo3.tp2;

public class Hacha extends Herramienta {
	
	public Hacha(Material material) {
		super(material);
	}
	
	@Override
	public int getDurabilidad() {
		return material.getDurabilidad(this);
	}

	@Override
	public int getFuerza() {
		return material.getFuerza(this);
	}
	
	public int getFuerzaMetal() {
		return 10;
	}
	
}
