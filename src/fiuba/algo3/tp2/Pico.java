package fiuba.algo3.tp2;

public class Pico extends Herramienta {
	
	public Pico(Material material){
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
		return 12;
	}
	
}
