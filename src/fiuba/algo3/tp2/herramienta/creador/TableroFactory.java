package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.material.*;

public class TableroFactory {

	public static Tablero newTableroHachaMadera() throws PosicionIncorrectaException {
		Tablero tablero= new TableroHachaMadera();
		tablero.setMaterial(new Madera(), 1);
		tablero.setMaterial(new Madera(), 2);
		tablero.setMaterial(new Madera(), 4);
		tablero.setMaterial(new Madera(), 5);
		tablero.setMaterial(new Madera(), 8);
		return tablero;
	}
	
	public static Tablero newTableroHachaPiedra() throws PosicionIncorrectaException {
		Tablero tablero= new TableroHachaPiedra();
		tablero.setMaterial(new Piedra(), 1);
		tablero.setMaterial(new Piedra(), 2);
		tablero.setMaterial(new Piedra(), 4);
		tablero.setMaterial(new Madera(), 5);
		tablero.setMaterial(new Madera(), 8);
		return tablero;
	}
	
	public static Tablero newTableroHachaMetal() throws PosicionIncorrectaException {
		Tablero tablero= new TableroHachaMetal();
		tablero.setMaterial(new Metal(), 1);
		tablero.setMaterial(new Metal(), 2);
		tablero.setMaterial(new Metal(), 4);
		tablero.setMaterial(new Madera(), 5);
		tablero.setMaterial(new Madera(), 8);
		return tablero;
	}
	
	public static Tablero newTableroPicoMadera() throws PosicionIncorrectaException {
		Tablero tablero= new TableroPicoMadera();
		tablero.setMaterial(new Madera(), 1);
		tablero.setMaterial(new Madera(), 2);
		tablero.setMaterial(new Madera(), 3);
		tablero.setMaterial(new Madera(), 5);
		tablero.setMaterial(new Madera(), 8);
		return tablero;
	}
	
	public static Tablero newTableroPicoPiedra() throws PosicionIncorrectaException {
		Tablero tablero= new TableroPicoPiedra();
		tablero.setMaterial(new Piedra(), 1);
		tablero.setMaterial(new Piedra(), 2);
		tablero.setMaterial(new Piedra(), 3);
		tablero.setMaterial(new Madera(), 5);
		tablero.setMaterial(new Madera(), 8);
		return tablero;
	}
	
	public static Tablero newTableroPicoMetal() throws PosicionIncorrectaException {
		Tablero tablero= new TableroPicoMetal();
		tablero.setMaterial(new Metal(), 1);
		tablero.setMaterial(new Metal(), 2);
		tablero.setMaterial(new Metal(), 3);
		tablero.setMaterial(new Madera(), 5);
		tablero.setMaterial(new Madera(), 8);
		return tablero;
	}
	
	public static Tablero newTableroPicoFino() throws PosicionIncorrectaException {
		Tablero tablero= new TableroPicoFino();
		tablero.setMaterial(new Metal(), 1);
		tablero.setMaterial(new Metal(), 2);
		tablero.setMaterial(new Metal(), 3);
		tablero.setMaterial(new Piedra(), 4);
		tablero.setMaterial(new Madera(), 5);
		tablero.setMaterial(new Madera(), 8);
		return tablero;
	}

}
