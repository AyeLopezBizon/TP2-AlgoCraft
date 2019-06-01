package fiuba.algo3.tp2;

public abstract class Herramienta {
	
	protected Material material;
	
	public Herramienta(Material material) {
		this.material=material;
	}
	
	public abstract float getDurabilidad();

	public abstract int getFuerza();
	
	public abstract int getFuerzaMetal();

	public abstract void usar(MaterialCubo materialCubo);
}
