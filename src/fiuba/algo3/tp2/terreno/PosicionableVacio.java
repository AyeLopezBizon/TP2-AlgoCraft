package fiuba.algo3.tp2.terreno;

public class PosicionableVacio implements Posicionable {

	private Posicion posicion;
	
	
	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
}
