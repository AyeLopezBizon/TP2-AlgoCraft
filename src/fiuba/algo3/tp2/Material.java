package fiuba.algo3.tp2;

public abstract class Material {
	public abstract float getDurabilidad(Herramienta herramienta);
	
	public abstract int getFuerza(Herramienta herramienta);

	public abstract void reducirDurabilidad(Herramienta herramienta, MaterialCubo materialCubo);
}
