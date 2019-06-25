package fiuba.algo3.tp2.vista;

public class Imagen {

	private final static String imagenesBasePath = "file:src/fiuba/algo3/tp2/vista/resources/imagenes";
	
	private final static String fondoInicioRelativePath = "inicio/fondo.jpg";
	private final static String fondoTerrenoRelativePath = "terreno/fondo.jpg";
	private final static String imagenJugador = "terreno/Jugador.png";
	private final static String imagenJugadorGolpeando = "terreno/JugadorGolpeando.png";
	
	
	public static final String FONDO_INICIO = obtenerPath(fondoInicioRelativePath);
	public static final String FONDO_TERRENO = obtenerPath(fondoTerrenoRelativePath);
	public static final String IMAGEN_JUGADOR = obtenerPath(imagenJugador);
	public static final String IMAGEN_JUGADOR_GOLPEANDO = obtenerPath(imagenJugadorGolpeando);
	

	private static String obtenerBasePath() {
		return imagenesBasePath;
	}
	
	private static String obtenerPath(String relativePath) {
		return obtenerBasePath() + "/" + relativePath;
	}
	
	public static String obtenerImagenMaterialDebilitado(String nombreClaseMaterial) {
		return obtenerBasePath() + "/terreno/" + nombreClaseMaterial + "MitadVida.png";
	}
	
	public static String obtenerImagenMaterial(String nombreClaseMaterial) {
		return obtenerBasePath() + "/terreno/" + nombreClaseMaterial + ".png";
	}
}
