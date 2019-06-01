package fiuba.algo3.tp2;

public class Metal extends Material{
	public float getDurabilidad(Herramienta herramienta) {
		return 400;
	}
	
	public int getFuerza(Herramienta herramienta) {
		return herramienta.getFuerzaMetal();
	}

	@Override
	public void reducirDurabilidad(Herramienta herramienta, MaterialCubo materialCubo) {

	}
}
