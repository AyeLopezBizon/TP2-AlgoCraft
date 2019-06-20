package fiuba.algo3.tp2.vista.terreno;

import fiuba.algo3.tp2.modelo.terreno.Terreno;

public class VistaTerreno {
	
	public static int TAMANIO_NODO = 30;
	
	private Terreno terreno;
	private ContenedorTerreno contenedorTerreno;

	
	public VistaTerreno(Terreno terreno, ContenedorTerreno contenedorTerreno) {
		
		this.terreno = terreno;
		this.contenedorTerreno = contenedorTerreno;
	}
}