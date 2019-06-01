package fiuba.algo3.tp2;

public class Madera extends Material {

	int durabilidad = 100;
	int fuerza = 2;

	public float getDurabilidad(Herramienta herramienta) {
		return durabilidad;
	}
	
	public int getFuerza(Herramienta herramienta) {
		return fuerza;
	}

	@Override
	public void reducirDurabilidad(Herramienta herramienta, MaterialCubo materialCubo) {
		durabilidad -= fuerza;
	}
}
