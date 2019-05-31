package fiuba.algo3.tp2;

public abstract class Herramienta {
	
	protected Material material;
	
	public Herramienta(Material material) {
		this.material=material;
	}
	
	public abstract int getDurabilidad();

	public abstract int getFuerza();
	
	public abstract int getFuerzaMetal();
}
