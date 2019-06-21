package fiuba.algo3.tp2.modelo.matriz.direccion;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public abstract class Direccion {
	
	public static Direccion ARRIBA = new DireccionArriba();
	public static Direccion DIAGONAL_SUPERIOR_DERECHA = new DireccionDiagonalSuperiorDerecha();
	public static Direccion DERECHA = new DireccionDerecha();
	public static Direccion DIAGONAL_INFERIOR_DERECHA = new DireccionDiagonalInferiorDerecha();
	public static Direccion ABAJO = new DireccionAbajo();
	public static Direccion DIAGONAL_INFERIOR_IZQUIERDA = new DireccionDiagonalInferiorIzquierda();
	public static Direccion IZQUIERDA = new DireccionIzquierda();
	public static Direccion DIAGONAL_SUPERIOR_IZQUIERDA = new DireccionDiagonalSuperiorIzquierda();
	
	
	
	public abstract Posicion obtenerPosicion(Posicion posicion);
	
	
	private static class DireccionArriba extends Direccion {
		
		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.avanzarFila();
		}
	}
	
	private static class DireccionDiagonalSuperiorDerecha extends Direccion {

		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.avanzarFila().avanzarColumna();
		}
	}
	
	private static class DireccionDerecha extends Direccion {

		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.avanzarColumna();
		}
	}
	
	private static class DireccionDiagonalInferiorDerecha extends Direccion {

		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.retrocederFila().avanzarColumna();
		}
	}
	
	private static class DireccionAbajo extends Direccion {

		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.retrocederFila();
		}
	}
	
	private static class DireccionDiagonalInferiorIzquierda extends Direccion {

		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.retrocederFila().retrocederColumna();
		}
	}

	private static class DireccionIzquierda extends Direccion {

		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.retrocederColumna();
		}
	}

	private static class DireccionDiagonalSuperiorIzquierda extends Direccion {

		@Override
		public Posicion obtenerPosicion(Posicion posicion) {
			return posicion.avanzarFila().retrocederColumna();
		}
	}
}
