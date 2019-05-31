package fiuba.algo3.tp2;

public class Metal extends Material{
	public int getDurabilidad(Herramienta herramienta) {
		return 400;
	}
	
	public int getFuerza(Herramienta herramienta) {
		return herramienta.getFuerzaMetal();
	}
}
