package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.material.*;

public class Tablero {
	
	Material[] material;
	
	Tablero(){
		for(int i=0;i<9;i++) {
			this.material[i]= new Vacio();	
		}
		
	}
	
	public void setMaterial(Material material, int posicion) {
		this.material[posicion]=material;
	}
	
	public Material getCasilla(int posicion) {
		return material[posicion];
	}
	
}
