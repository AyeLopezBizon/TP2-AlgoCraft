package fiuba.algo3.tp2.herramienta.creador;

import java.util.Arrays;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;

public class Tablero {
	
	Material[] material;
	
	public Tablero(){
		material=new Material[9];
		for(int i=0;i<9;i++) {
			this.material[i]= new Vacio();	
		}
		
	}
	
	public void setMaterial(Material material, int posicion) {
		this.material[posicion-1]=material;
	}
	
	public Material getCasilla(int posicion) {
		return material[posicion-1];
	}
	
	public boolean comparar(Tablero tablero) {
		boolean valor = true;
		
		for(int i=0;i<9;i++) {
			if((material[i].getDurabilidad().intValue()) != (tablero.getCasilla(i+1).getDurabilidad().intValue())) {
				valor=false;
			}
		}
		
		return valor;
	}
	
	public Material[] getMateriales() {
		return material;
	}
	
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMadera();
	}
}
