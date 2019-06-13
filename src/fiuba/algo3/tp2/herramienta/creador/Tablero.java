package fiuba.algo3.tp2.herramienta.creador;

import java.util.Arrays;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.material.*;

public class Tablero {
	
	Material[] material;

	public Tablero(){

		material = new Material[9];

		for(int i = 0; i < 9; i++) {
			this.material[i]= new Vacio();
		}
	}
	
	public void setMaterial(Material material, int posicion) throws PosicionIncorrectaException {
		if(posicion<1 || posicion>9) {
			throw new PosicionIncorrectaException();
		}
		
		this.material[posicion-1]=material;
	}
	
	public Material getCasilla(int posicion) throws PosicionIncorrectaException {
		if(posicion<1 || posicion>9) {
			throw new PosicionIncorrectaException();
		}
		
		return material[posicion-1];
	}
	
	public boolean comparar(Tablero tablero) throws PosicionIncorrectaException {
		boolean valor = true;
		
		for(int i=0;i<9;i++) {
			if(!material[i].getClass().equals(tablero.getCasilla(i+1).getClass())) {
				valor=false;
			}
		}
		
		return valor;
	}
	
	public Material[] getMateriales() {
		return material;
	}

	public Herramienta crearHerramienta() {
		return null;
	}
}
