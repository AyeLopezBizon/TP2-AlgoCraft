package fiuba.algo3.tp2.herramienta.creador;

import java.math.BigDecimal;

import fiuba.algo3.tp2.herramienta.*;

public class CreadorHerramienta {
	
	private Tablero tablero;
	private Tablero[] tablerosPredeterminados;
	
	public CreadorHerramienta(Tablero tablero) throws PosicionIncorrectaException{
		this.tablero = tablero;

		tablerosPredeterminados = new Tablero[7];
		tablerosPredeterminados[0] = TableroFactory.newTableroHachaMadera();
		tablerosPredeterminados[1] = TableroFactory.newTableroHachaPiedra();
		tablerosPredeterminados[2] = TableroFactory.newTableroHachaMetal();
		tablerosPredeterminados[3] = TableroFactory.newTableroPicoMadera();
		tablerosPredeterminados[4] = TableroFactory.newTableroPicoPiedra();
		tablerosPredeterminados[5] = TableroFactory.newTableroPicoMetal();
		tablerosPredeterminados[6] = TableroFactory.newTableroPicoFino();			
	}
	
	public Herramienta crearHerramienta() throws MaterialesMalPosicionadosException, PosicionIncorrectaException {
		Herramienta herramienta;
		herramienta = comparar();
		return herramienta;
	}
	
	private Herramienta comparar() throws MaterialesMalPosicionadosException, PosicionIncorrectaException {		
		for(int i=0;i<7;i++){
			if(tablerosPredeterminados[i].comparar(tablero)){
				return tablerosPredeterminados[i].crearHerramienta();
			}
		}
		throw new MaterialesMalPosicionadosException();		
	}
}
