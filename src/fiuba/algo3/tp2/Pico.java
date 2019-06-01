package fiuba.algo3.tp2;

public class Pico extends Herramienta {
	
	public Pico(Material material){
		super(material);
	}
	
	@Override
	public float getDurabilidad() {
		return material.getDurabilidad(this);
	}

	@Override
	public int getFuerza() {
		return material.getFuerza(this);
	}
	
	public int getFuerzaMetal() {
		return 12;
	}

	@Override
	public void usar(MaterialCubo materialCubo) {
		material.reducirDurabilidad(this, materialCubo);
	}

}
